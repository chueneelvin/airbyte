# AgileCRM
The [Agile CRM](https://agilecrm.com/) Airbyte Connector allows you to sync and transfer data seamlessly from Agile CRM into your preferred data warehouse or analytics tool. With this connector, you can automate data extraction for various Agile CRM entities, such as contacts, companies, deals, and tasks, enabling easy integration and analysis of your CRM data in real-time. Ideal for businesses looking to streamline data workflows and enhance data accessibility.

## Configuration

| Input | Type | Description | Default Value |
|-------|------|-------------|---------------|
| `email` | `string` | Email Address. Your Agile CRM account email address. This is used as the username for authentication. |  |
| `domain` | `string` | Domain. The specific subdomain for your Agile CRM account |  |
| `api_key` | `string` | API Key. API key to use. Find it at Admin Settings -&gt; API &amp; Analytics -&gt; API Key in your Agile CRM account. |  |

## Streams
| Stream Name | Primary Key | Pagination | Supports Full Sync | Supports Incremental |
|-------------|-------------|------------|---------------------|----------------------|
| contacts | id | DefaultPaginator | ✅ |  ❌  |
| companies | id | DefaultPaginator | ✅ |  ❌  |
| deals | id | DefaultPaginator | ✅ |  ❌  |
| notes | id | No pagination | ✅ |  ❌  |
| tasks | id | No pagination | ✅ |  ❌  |
| milestone | id | No pagination | ✅ |  ❌  |
| campaigns | id | DefaultPaginator | ✅ |  ❌  |
| documents | id | No pagination | ✅ |  ❌  |
| ticket_filters | id | No pagination | ✅ |  ❌  |
| tickets |  | No pagination | ✅ |  ❌  |

## Changelog

<details>
  <summary>Expand to review</summary>

| Version          | Date              | Pull Request | Subject        |
|------------------|-------------------|--------------|----------------|
| 0.0.25 | 2025-07-05 | [62538](https://github.com/airbytehq/airbyte/pull/62538) | Update dependencies |
| 0.0.24 | 2025-06-21 | [61109](https://github.com/airbytehq/airbyte/pull/61109) | Update dependencies |
| 0.0.23 | 2025-05-24 | [60661](https://github.com/airbytehq/airbyte/pull/60661) | Update dependencies |
| 0.0.22 | 2025-05-10 | [59338](https://github.com/airbytehq/airbyte/pull/59338) | Update dependencies |
| 0.0.21 | 2025-04-26 | [58694](https://github.com/airbytehq/airbyte/pull/58694) | Update dependencies |
| 0.0.20 | 2025-04-19 | [58248](https://github.com/airbytehq/airbyte/pull/58248) | Update dependencies |
| 0.0.19 | 2025-04-12 | [57630](https://github.com/airbytehq/airbyte/pull/57630) | Update dependencies |
| 0.0.18 | 2025-04-05 | [57141](https://github.com/airbytehq/airbyte/pull/57141) | Update dependencies |
| 0.0.17 | 2025-03-29 | [56558](https://github.com/airbytehq/airbyte/pull/56558) | Update dependencies |
| 0.0.16 | 2025-03-22 | [56096](https://github.com/airbytehq/airbyte/pull/56096) | Update dependencies |
| 0.0.15 | 2025-03-08 | [55419](https://github.com/airbytehq/airbyte/pull/55419) | Update dependencies |
| 0.0.14 | 2025-03-01 | [54908](https://github.com/airbytehq/airbyte/pull/54908) | Update dependencies |
| 0.0.13 | 2025-02-22 | [54256](https://github.com/airbytehq/airbyte/pull/54256) | Update dependencies |
| 0.0.12 | 2025-02-15 | [53924](https://github.com/airbytehq/airbyte/pull/53924) | Update dependencies |
| 0.0.11 | 2025-02-08 | [53425](https://github.com/airbytehq/airbyte/pull/53425) | Update dependencies |
| 0.0.10 | 2025-02-01 | [52913](https://github.com/airbytehq/airbyte/pull/52913) | Update dependencies |
| 0.0.9 | 2025-01-25 | [52214](https://github.com/airbytehq/airbyte/pull/52214) | Update dependencies |
| 0.0.8 | 2025-01-18 | [51764](https://github.com/airbytehq/airbyte/pull/51764) | Update dependencies |
| 0.0.7 | 2025-01-11 | [51269](https://github.com/airbytehq/airbyte/pull/51269) | Update dependencies |
| 0.0.6 | 2024-12-28 | [50483](https://github.com/airbytehq/airbyte/pull/50483) | Update dependencies |
| 0.0.5 | 2024-12-21 | [50157](https://github.com/airbytehq/airbyte/pull/50157) | Update dependencies |
| 0.0.4 | 2024-12-14 | [49588](https://github.com/airbytehq/airbyte/pull/49588) | Update dependencies |
| 0.0.3 | 2024-12-12 | [49279](https://github.com/airbytehq/airbyte/pull/49279) | Update dependencies |
| 0.0.2 | 2024-12-11 | [49026](https://github.com/airbytehq/airbyte/pull/49026) | Starting with this version, the Docker image is now rootless. Please note that this and future versions will not be compatible with Airbyte versions earlier than 0.64 |
| 0.0.1 | 2024-11-08 | | Initial release by [@parthiv11](https://github.com/parthiv11) via Connector Builder |

</details>
