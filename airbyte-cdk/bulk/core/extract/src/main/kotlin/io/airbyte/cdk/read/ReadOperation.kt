/* Copyright (c) 2024 Airbyte, Inc., all rights reserved. */
package io.airbyte.cdk.read

import hu.webarticum.treeprinter.SimpleTreeNode
import hu.webarticum.treeprinter.TreeNode
import hu.webarticum.treeprinter.printer.TreePrinter
import hu.webarticum.treeprinter.printer.listing.ListingTreePrinter
import io.airbyte.cdk.Operation
import io.airbyte.cdk.command.InputState
import io.airbyte.cdk.command.SourceConfiguration
import io.airbyte.cdk.discover.MetaFieldDecorator
import io.airbyte.cdk.output.CONNECTOR_OUTPUT_PREFIX
import io.airbyte.cdk.output.DataChannelFormat
import io.airbyte.cdk.output.DataChannelMedium
import io.airbyte.cdk.output.StandardOutputConsumer
import io.airbyte.cdk.output.sockets.DATA_CHANNEL_PROPERTY_PREFIX
import io.airbyte.cdk.util.ThreadRenamingCoroutineName
import io.airbyte.protocol.models.v0.ConfiguredAirbyteCatalog
import io.github.oshai.kotlinlogging.KotlinLogging
import io.micronaut.context.annotation.Requires
import io.micronaut.context.annotation.Value
import jakarta.inject.Singleton
import java.time.Clock
import kotlin.time.toKotlinDuration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Singleton
@Requires(property = Operation.PROPERTY, value = "read")
@Requires(env = ["source"])
class ReadOperation(
    val config: SourceConfiguration,
    val configuredCatalog: ConfiguredAirbyteCatalog,
    val inputState: InputState,
    val stateManagerFactory: StateManagerFactory,
    val outputConsumer: StandardOutputConsumer,
    val metaFieldDecorator: MetaFieldDecorator,
    val resourceAcquirer: ResourceAcquirer,
    val partitionsCreatorFactoriesSupplier:
        List<PartitionsCreatorFactorySupplier<PartitionsCreatorFactory>>,
    @Value("\${${DATA_CHANNEL_PROPERTY_PREFIX}.format}") val dataChannelFormat: String,
    @Value("\${${DATA_CHANNEL_PROPERTY_PREFIX}.medium}") val dataChannelMedium: String,
    @Value("\${$CONNECTOR_OUTPUT_PREFIX.buffer-byte-size-threshold-for-flush:4096}")
    val bufferByteSizeThresholdForFlush: Int,
    // Injected by [ClockFactory]
    private val clock: Clock,
) : Operation {
    private val log = KotlinLogging.logger {}

    override fun execute() {
        val stateManager: StateManager =
            stateManagerFactory.create(config, configuredCatalog, inputState)
        val rootReader =
            RootReader(
                stateManager,
                config.resourceAcquisitionHeartbeat,
                config.checkpointTargetInterval,
                outputConsumer,
                metaFieldDecorator,
                resourceAcquirer,
                partitionsCreatorFactoriesSupplier.map { it -> it.get() },
                DataChannelFormat.valueOf(dataChannelFormat),
                DataChannelMedium.valueOf(dataChannelMedium),
                bufferByteSizeThresholdForFlush,
                clock,
            )
        runBlocking(ThreadRenamingCoroutineName("read") + Dispatchers.Default) {
            rootReader.read { feedJobs: Collection<Job> ->
                val rootJob = coroutineContext.job
                launch(Job()) {
                    var previousJobTree = ""
                    while (feedJobs.any { it.isActive }) {
                        val currentJobTree: String = renderTree(rootJob)
                        if (currentJobTree != previousJobTree) {
                            log.info { "coroutine state:\n$currentJobTree" }
                            previousJobTree = currentJobTree
                        }
                        delay(config.resourceAcquisitionHeartbeat.toKotlinDuration())
                    }
                }
            }
        }
    }

    companion object {
        private val treePrinter: TreePrinter = ListingTreePrinter.builder().unicode().build()

        private fun renderTree(feedsRootJob: Job): String {
            val rootNode: TreeNode = recursiveBuildTree(feedsRootJob)
            return treePrinter.stringify(rootNode)
        }

        private fun recursiveBuildTree(job: Job): TreeNode {
            val name: String = label(job) ?: "???"
            val node = SimpleTreeNode(name)
            var children: List<Job> = job.children.toList()
            // Collapse chains of jobs with identical names.
            while (children.any { label(it) == name }) {
                children =
                    children.flatMap {
                        if (label(it) == name) {
                            it.children.toList()
                        } else {
                            listOf(it)
                        }
                    }
            }
            for (child in children) {
                node.addChild(recursiveBuildTree(child))
            }
            return node
        }

        private fun label(job: Job): String? =
            (job as? CoroutineScope)?.coroutineContext?.get(ThreadRenamingCoroutineName)?.name
    }
}
