# MetaStats forex metrics API

Note: The Java SDK was updated long time ago and lacks important bugfixes and updates. We plan to update the java SDK soon. Meanwhile we recommend you to use javascript or python SDK instead. 

MetaStats is a fast, cost-efficient, easy to use and standards-driven cloud forex trading statistics API supporting both MetaTrader 4 and MetaTrader 5 platforms designed to boost forex application development process.

Using MetaStats API you can develop applications similar to Myfxbook or MetriX extremely fast, saving time you otherwise spend for coding, optimizing and testing your own trading metrics calculation engine, since we already did it for you.

MetaStats API is a member of MetaApi project ([https://metaapi.cloud](https://metaapi.cloud)), a powerful cloud forex trading API which supports both MetaTrader 4 and MetaTrader 5 platforms.

## MetaStats API features
Features supported:

- support for MetaTrader 4 and MetaTrader 5 platforms
- metrics calculation for MetaTrader accounts added to MetaApi
- optionally include open positions in metrics calculation

The features described above are available for use via a professional, fast, easy to use, standards-driven REST API which can be easily consumed from any programming language.

The primary intended use of MetaStats API is creating trade monitoring applications.

## Pricing
MetaStats is available to all MetaApi users without extra charges at this point.

You pay a fee executing MetaTrader terminal on MetaApi cloud. See [https://metaapi.cloud/#pricing](https://metaapi.cloud/#pricing) for more details.

MetaApi provides a free tier so that you can test our APIs without any charges.

## Frequently asked questions (FAQ)
FAQ is located here: [http://metaapi.cloud/docs/metastats/faq/](http://metaapi.cloud/docs/metastats/faq/)

## REST API documentation
MetaStats SDK is built on top of MetaStats REST API.

MetaStats REST API docs are available at [https://metaapi.cloud/docs/metastats/](https://metaapi.cloud/docs/metastats/)

## Code examples
We published some code examples in our github repository, namely:

- Java: [https://github.com/metaapi/metaapi-metastats-java-sdk/tree/master/examples](https://github.com/metaapi/metaapi-metastats-java-sdk/tree/master/examples)

## Installation
If you use Apache Maven, add this to `<dependencies>` in your `pom.xml`:
```xml
<dependency>
  <groupId>cloud.metaapi.sdk</groupId>
  <artifactId>metaapi-java-sdk</artifactId>
  <version>14.0.0</version>
</dependency>
```

Other options can be found on [this page](https://search.maven.org/artifact/cloud.metaapi.sdk/metaapi-java-sdk/14.0.0/jar).

### Running examples
In order to run the examples, follow these steps:
1. Make sure that you have installed [Maven](http://maven.apache.org) and its command `mvn` is accessible.
2. Navigate to the root folder of the example project (where its `pom.xml` is located).
3. Build the project with `mvn package`.
4. Run `mvn exec:java@`_`ExampleClassName`_ where _`ExampleClassName`_ is the example to execute, e.g. `mvn exec:java@MetaStatsExample`.

Example parameters such as token or account id can be passed via environment variables, or set directly in the example source code. In the last case you need to rebuild the example with `mvn package`. 

## Retrieving API token
Please visit [https://app.metaapi.cloud/token](https://app.metaapi.cloud/token) web UI to obtain your API token.

## Configuring trading statistics
```java
import cloud.metaapi.sdk.MetaStats;

String token = "...";
MetaStats metaStats = new MetaStats(token);
```
See javadoc in-code documentation for full definition of possible configuration options.

## Retrieving trading statistics
```java
String accountId = "..."; // MetaApi account id

// retrieve MetaApi MetaTrader account statistics
System.out.println(metaStats.getMetrics(accountId).join());

// retrieve MetaApi MetaTrader account statistics including open positions
System.out.println(metaStats.getMetrics(accountId, true).join());
```

## Quotas and rate limits
API calls you make are subject to rate limits. See [https://metaapi.cloud/docs/metastats/rateLimiting/](https://metaapi.cloud/docs/metastats/rateLimiting/) for more details.

## Related projects:
See our website for the full list of APIs and features supported [https://metaapi.cloud/#features](https://metaapi.cloud/#features)

Some of the APIs you might decide to use together with this module:

1. MetaApi cloud forex trading API [https://metaapi.cloud/docs/client/](https://metaapi.cloud/docs/client/)
2. CopyFactory copy trading  API [https://metaapi.cloud/docs/copyfactory/](https://metaapi.cloud/docs/copyfactory/)
3. MetaTrader account management API [https://metaapi.cloud/docs/provisioning/](https://metaapi.cloud/docs/provisioning/)
