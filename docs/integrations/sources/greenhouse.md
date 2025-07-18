# Greenhouse

This page contains the setup guide and reference information for the Greenhouse source connector.

## Prerequisites

To set up the Greenhouse source connector, you'll need the [Harvest API key](https://developers.greenhouse.io/harvest.html#authentication) with permissions to the resources Airbyte should be able to access.

## Set up the Greenhouse connector in Airbyte

1. [Log into your Airbyte Cloud](https://cloud.airbyte.com/workspaces) account or navigate to the Airbyte Open Source dashboard.
2. Click **Sources** and then click **+ New source**.
3. On the Set up the source page, select **Greenhouse** from the Source type dropdown.
4. Enter the name for the Greenhouse connector.
5. Enter your [**Harvest API Key**](https://developers.greenhouse.io/harvest.html#authentication) that you obtained from Greenhouse.
6. Click **Set up source**.

## Supported sync modes

The Greenhouse source connector supports the following [sync modes](https://docs.airbyte.com/cloud/core-concepts#connection-sync-modes):

- [Full Refresh - Overwrite](https://docs.airbyte.com/understanding-airbyte/connections/full-refresh-overwrite/)
- [Full Refresh - Append](https://docs.airbyte.com/understanding-airbyte/connections/full-refresh-append)
- [Incremental - Append](https://docs.airbyte.com/understanding-airbyte/connections/incremental-append)
- [Incremental - Append + Deduped](https://docs.airbyte.com/understanding-airbyte/connections/incremental-append-deduped)

## Supported Streams

- [Activity Feed](https://developers.greenhouse.io/harvest.html#get-retrieve-activity-feed)
- [Applications](https://developers.greenhouse.io/harvest.html#get-list-applications) \(Incremental\)
- [Applications Interviews](https://developers.greenhouse.io/harvest.html#get-list-scheduled-interviews-for-application) \(Incremental\)
- [Applications Demographics Answers](https://developers.greenhouse.io/harvest.html#get-list-demographic-answers-for-application) \(Incremental\)
- [Demographics Answers](https://developers.greenhouse.io/harvest.html#get-list-demographic-answers) \(Incremental\)
- [Demographic Answer Options](https://developers.greenhouse.io/harvest.html#get-list-demographic-answer-options)
- [Demographic Answer Options For Question](https://developers.greenhouse.io/harvest.html#get-list-demographic-answer-options-for-demographic-question)
- [Demographic Questions](https://developers.greenhouse.io/harvest.html#get-list-demographic-questions)
- [Demographic Question Set](https://developers.greenhouse.io/harvest.html#get-list-demographic-question-sets)
- [Demographic Questions For Question Set](https://developers.greenhouse.io/harvest.html#get-list-demographic-questions-for-demographic-question-set)
- [Approvals](https://developers.greenhouse.io/harvest.html#get-list-approvals-for-job)
- [Candidates](https://developers.greenhouse.io/harvest.html#get-list-candidates) \(Incremental\)
- [Close Reasons](https://developers.greenhouse.io/harvest.html#get-list-close-reasons)
- [Custom Fields](https://developers.greenhouse.io/harvest.html#get-list-custom-fields)
- [Degrees](https://developers.greenhouse.io/harvest.html#get-list-degrees)
- [Departments](https://developers.greenhouse.io/harvest.html#get-list-departments)
- [Disciplines](https://developers.greenhouse.io/harvest.html#get-list-approvals-for-job)
- [EEOC](https://developers.greenhouse.io/harvest.html#get-list-eeoc) \(Incremental\)
- [Email Templates](https://developers.greenhouse.io/harvest.html#get-list-email-templates) \(Incremental\)
- [Interviews](https://developers.greenhouse.io/harvest.html#get-list-scheduled-interviews) \(Incremental\)
- [Job Posts](https://developers.greenhouse.io/harvest.html#get-list-job-posts) \(Incremental\)
- [Job Stages](https://developers.greenhouse.io/harvest.html#get-list-job-stages) \(Incremental\)
- [Jobs](https://developers.greenhouse.io/harvest.html#get-list-jobs) \(Incremental\)
- [Job Openings](https://developers.greenhouse.io/harvest.html#get-list-job-openings)
- [Jobs Stages](https://developers.greenhouse.io/harvest.html#get-list-job-stages-for-job) \(Incremental\)
- [Offers](https://developers.greenhouse.io/harvest.html#get-list-offers) \(Incremental\)
- [Offices](https://developers.greenhouse.io/harvest.html#get-list-offices)
- [Prospect Pools](https://developers.greenhouse.io/harvest.html#get-list-prospect-pools)
- [Rejection Reasons](https://developers.greenhouse.io/harvest.html#get-list-rejection-reasons)
- [Schools](https://developers.greenhouse.io/harvest.html#get-list-schools)
- [Scorecards](https://developers.greenhouse.io/harvest.html#get-list-scorecards) \(Incremental\)
- [Sources](https://developers.greenhouse.io/harvest.html#get-list-sources)
- [Tags](https://developers.greenhouse.io/harvest.html#get-list-candidate-tags)
- [Users](https://developers.greenhouse.io/harvest.html#get-list-users) \(Incremental\)
- [User Permissions](https://developers.greenhouse.io/harvest.html#get-list-job-permissions)
- [User Roles](https://developers.greenhouse.io/harvest.html#the-user-role-object)

## Performance considerations

The Greenhouse connector should not run into Greenhouse API limitations under normal usage. [Create an issue](https://github.com/airbytehq/airbyte/issues) if you encounter any rate limit issues that are not automatically retried successfully.

## Changelog

<details>
  <summary>Expand to review</summary>

| Version    | Date       | Pull Request                                             | Subject                                                                                                                                                                |
|:-----------|:-----------|:---------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 0.7.0 | 2025-07-07 | [62830](https://github.com/airbytehq/airbyte/pull/62830) | Promoting release candidate 0.7.0-rc.1 to a main version. |
| 0.7.0-rc.1  | 2025-06-29 | [47283](https://github.com/airbytehq/airbyte/pull/47283) | Migrate to Manifest-only |
| 0.6.1 | 2025-03-22 | [53800](https://github.com/airbytehq/airbyte/pull/53800) | Update dependencies |
| 0.6.0 | 2025-03-14 | [55774](https://github.com/airbytehq/airbyte/pull/55774) | Promoting release candidate 0.6.0-rc.1 to a main version. |
| 0.6.0-rc.1 | 2025-03-14 | [54702](https://github.com/airbytehq/airbyte/pull/54702) | Update to latest airbyte-cdk, remove custom cursors.                                                                                                                   |
| 0.5.32     | 2025-02-01 | [52724](https://github.com/airbytehq/airbyte/pull/52724) | Update dependencies                                                                                                                                                    |
| 0.5.31     | 2025-01-25 | [51842](https://github.com/airbytehq/airbyte/pull/51842) | Update dependencies                                                                                                                                                    |
| 0.5.30     | 2025-01-11 | [51214](https://github.com/airbytehq/airbyte/pull/51214) | Update dependencies                                                                                                                                                    |
| 0.5.29     | 2024-12-28 | [50632](https://github.com/airbytehq/airbyte/pull/50632) | Update dependencies                                                                                                                                                    |
| 0.5.28     | 2024-12-21 | [50109](https://github.com/airbytehq/airbyte/pull/50109) | Update dependencies                                                                                                                                                    |
| 0.5.27     | 2024-12-14 | [49248](https://github.com/airbytehq/airbyte/pull/49248) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.5.26     | 2024-12-12 | [48996](https://github.com/airbytehq/airbyte/pull/48996) | Update dependencies                                                                                                                                                    |
| 0.5.25     | 2024-10-29 | [47110](https://github.com/airbytehq/airbyte/pull/47110) | Update dependencies                                                                                                                                                    |
| 0.5.24     | 2024-10-23 | [47306](https://github.com/airbytehq/airbyte/pull/47306) | Add 'job_post_id' to applications stream scehma                                                                                                                        |
| 0.5.23     | 2024-10-12 | [46828](https://github.com/airbytehq/airbyte/pull/46828) | Update dependencies                                                                                                                                                    |
| 0.5.22     | 2024-10-05 | [46506](https://github.com/airbytehq/airbyte/pull/46506) | Update dependencies                                                                                                                                                    |
| 0.5.21     | 2024-09-28 | [46159](https://github.com/airbytehq/airbyte/pull/46159) | Update dependencies                                                                                                                                                    |
| 0.5.20     | 2024-09-21 | [45834](https://github.com/airbytehq/airbyte/pull/45834) | Update dependencies                                                                                                                                                    |
| 0.5.19     | 2024-09-17 | [45625](https://github.com/airbytehq/airbyte/pull/45625) | Change check stream                                                                                                                                                    |
| 0.5.18     | 2024-09-14 | [45476](https://github.com/airbytehq/airbyte/pull/45476) | Update dependencies                                                                                                                                                    |
| 0.5.17     | 2024-09-07 | [45229](https://github.com/airbytehq/airbyte/pull/45229) | Update dependencies                                                                                                                                                    |
| 0.5.16     | 2024-08-31 | [44755](https://github.com/airbytehq/airbyte/pull/44755) | Update dependencies                                                                                                                                                    |
| 0.5.15     | 2024-08-17 | [44246](https://github.com/airbytehq/airbyte/pull/44246) | Update dependencies                                                                                                                                                    |
| 0.5.14     | 2024-08-10 | [43595](https://github.com/airbytehq/airbyte/pull/43595) | Update dependencies                                                                                                                                                    |
| 0.5.13     | 2024-08-03 | [43160](https://github.com/airbytehq/airbyte/pull/43160) | Update dependencies                                                                                                                                                    |
| 0.5.12     | 2024-07-27 | [42816](https://github.com/airbytehq/airbyte/pull/42816) | Update dependencies                                                                                                                                                    |
| 0.5.11     | 2024-07-20 | [42240](https://github.com/airbytehq/airbyte/pull/42240) | Update dependencies                                                                                                                                                    |
| 0.5.10     | 2024-07-13 | [41787](https://github.com/airbytehq/airbyte/pull/41787) | Update dependencies                                                                                                                                                    |
| 0.5.9      | 2024-07-10 | [41215](https://github.com/airbytehq/airbyte/pull/41215) | Update dependencies                                                                                                                                                    |
| 0.5.8      | 2024-07-10 | [39601](https://github.com/airbytehq/airbyte/pull/39601) | Move spec to manifest, fix readme                                                                                                                                      |
| 0.5.7      | 2024-07-06 | [40882](https://github.com/airbytehq/airbyte/pull/40882) | Update dependencies                                                                                                                                                    |
| 0.5.6      | 2024-06-25 | [40451](https://github.com/airbytehq/airbyte/pull/40451) | Update dependencies                                                                                                                                                    |
| 0.5.5      | 2024-06-22 | [39968](https://github.com/airbytehq/airbyte/pull/39968) | Update dependencies                                                                                                                                                    |
| 0.5.4      | 2024-06-06 | [39247](https://github.com/airbytehq/airbyte/pull/39247) | [autopull] Upgrade base image to v1.2.2                                                                                                                                |
| 0.5.3      | 2024-04-19 | [36640](https://github.com/airbytehq/airbyte/pull/36640) | Updating to 0.80.0 CDK                                                                                                                                                 |
| 0.5.2      | 2024-04-12 | [36640](https://github.com/airbytehq/airbyte/pull/36640) | schema descriptions                                                                                                                                                    |
| 0.5.1      | 2024-03-12 | [35988](https://github.com/airbytehq/airbyte/pull/35988) | Unpin CDK version                                                                                                                                                      |
| 0.5.0      | 2024-02-20 | [35465](https://github.com/airbytehq/airbyte/pull/35465) | Per-error reporting and continue sync on stream failures                                                                                                               |
| 0.4.5      | 2024-02-09 | [35077](https://github.com/airbytehq/airbyte/pull/35077) | Manage dependencies with Poetry.                                                                                                                                       |
| 0.4.4      | 2023-11-29 | [32397](https://github.com/airbytehq/airbyte/pull/32397) | Increase test coverage and migrate to base image                                                                                                                       |
| 0.4.3      | 2023-09-20 | [30648](https://github.com/airbytehq/airbyte/pull/30648) | Update candidates.json                                                                                                                                                 |
| 0.4.2      | 2023-08-02 | [28969](https://github.com/airbytehq/airbyte/pull/28969) | Update CDK version                                                                                                                                                     |
| 0.4.1      | 2023-06-28 | [27773](https://github.com/airbytehq/airbyte/pull/27773) | Update following state breaking changes                                                                                                                                |
| 0.4.0      | 2023-04-26 | [25332](https://github.com/airbytehq/airbyte/pull/25332) | Add new streams: `ActivityFeed`, `Approvals`, `Disciplines`, `Eeoc`, `EmailTemplates`, `Offices`, `ProspectPools`, `Schools`, `Tags`, `UserPermissions`, `UserRoles`   |
| 0.3.1      | 2023-03-06 | [23231](https://github.com/airbytehq/airbyte/pull/23231) | Publish using low-code CDK Beta version                                                                                                                                |
| 0.3.0      | 2022-10-19 | [18154](https://github.com/airbytehq/airbyte/pull/18154) | Extend `Users` stream schema                                                                                                                                           |
| 0.2.11     | 2022-09-27 | [17239](https://github.com/airbytehq/airbyte/pull/17239) | Always install the latest version of Airbyte CDK                                                                                                                       |
| 0.2.10     | 2022-09-05 | [16338](https://github.com/airbytehq/airbyte/pull/16338) | Implement incremental syncs & fix SATs                                                                                                                                 |
| 0.2.9      | 2022-08-22 | [15800](https://github.com/airbytehq/airbyte/pull/15800) | Bugfix to allow reading sentry.yaml and schemas at runtime                                                                                                             |
| 0.2.8      | 2022-08-10 | [15344](https://github.com/airbytehq/airbyte/pull/15344) | Migrate connector to config-based framework                                                                                                                            |
| 0.2.7      | 2022-04-15 | [11941](https://github.com/airbytehq/airbyte/pull/11941) | Correct Schema data type for Applications, Candidates, Scorecards and Users                                                                                            |
| 0.2.6      | 2021-11-08 | [7607](https://github.com/airbytehq/airbyte/pull/7607)   | Implement demographics streams support. Update SAT for demographics streams                                                                                            |
| 0.2.5      | 2021-09-22 | [6377](https://github.com/airbytehq/airbyte/pull/6377)   | Refactor the connector to use CDK. Implement additional stream support                                                                                                 |
| 0.2.4      | 2021-09-15 | [6238](https://github.com/airbytehq/airbyte/pull/6238)   | Add identification of accessible streams for API keys with limited permissions                                                                                         |

</details>
