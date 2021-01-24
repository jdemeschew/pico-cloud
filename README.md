# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost/api/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------


## Documentation for Models

 - [Admin](docs/Admin.md)
 - [CliCallRequest](docs/CliCallRequest.md)
 - [CliCallResponse](docs/CliCallResponse.md)
 - [Client](docs/Client.md)
 - [ClientRequest](docs/ClientRequest.md)
 - [ClientStatistics](docs/ClientStatistics.md)
 - [ClientUpdateRequest](docs/ClientUpdateRequest.md)
 - [CreatedResponse](docs/CreatedResponse.md)
 - [Database](docs/Database.md)
 - [DatabaseRequest](docs/DatabaseRequest.md)
 - [DatabaseServer](docs/DatabaseServer.md)
 - [DatabaseUser](docs/DatabaseUser.md)
 - [DatabaseUserRequest](docs/DatabaseUserRequest.md)
 - [DatabaseUserUpdateRequest](docs/DatabaseUserUpdateRequest.md)
 - [DomainReference](docs/DomainReference.md)
 - [DomainRequest](docs/DomainRequest.md)
 - [DomainRequestHostingSettings](docs/DomainRequestHostingSettings.md)
 - [DomainResponse](docs/DomainResponse.md)
 - [DomainStatus](docs/DomainStatus.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [Extension](docs/Extension.md)
 - [ExtensionInstallRequest](docs/ExtensionInstallRequest.md)
 - [FtpUser](docs/FtpUser.md)
 - [FtpUserPermissions](docs/FtpUserPermissions.md)
 - [FtpUserRequest](docs/FtpUserRequest.md)
 - [FtpUserRequestPermissions](docs/FtpUserRequestPermissions.md)
 - [FtpUserUpdateRequest](docs/FtpUserUpdateRequest.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [OwnerClientReference](docs/OwnerClientReference.md)
 - [PlanReference](docs/PlanReference.md)
 - [SecretKeyRequest](docs/SecretKeyRequest.md)
 - [SecretKeyResponse](docs/SecretKeyResponse.md)
 - [ServerInit](docs/ServerInit.md)
 - [ServerIp](docs/ServerIp.md)
 - [ServerLicense](docs/ServerLicense.md)
 - [ServerMeta](docs/ServerMeta.md)
 - [StatusResponse](docs/StatusResponse.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### APIKeyHeader

- **Type**: API key
- **API key parameter name**: X-API-Key
- **Location**: HTTP header

### BasicAuth

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


