# RSpace API Client Model

Java classes to model RSpace API entities for JVM-based clients using the RSpace API. These classes provide type-safe creation of RSpace API entities with convenient builder methods for constructing request bodies.

## Features

- Type-safe API entity modeling
- Builder pattern for easy object construction
- Jackson JSON serialization support
- Minimal dependencies
- Backwards compatible with earlier API versions

## Quick Start

Here's an example of creating a document to post:

```java
DocumentPost post = DocumentPost.builder()
    .name("myDocument")
    .tags("a,b,c")
    .field(new FieldPost("content1"))
    .field(new FieldPost("content2"))
    .field(new FieldPost("content3"))
    .field(FieldPost.emptyField())
    .form(new FormRef(23))
    .build();
```

## Installation

### JitPack

Add the JitPack repository and dependency to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.rspace-os</groupId>
        <artifactId>rspace-client-java-model</artifactId>
        <version>1.98.1</version>
    </dependency>
</dependencies>
```

### Building from Source

To build the project locally:

```bash
mvn clean test package
```

This will run tests and build a jar in the `target` folder. No additional installation required.

## 📦 Releasing with JitPack

This project is published using [JitPack](https://jitpack.io). Releases are created from Git tags, and JitPack builds the library directly from GitHub to serve artifacts as Maven dependencies.

### Prerequisites

Before releasing, ensure:

- ✅ The build passes on `main` branch (GitHub Actions is green)
- ✅ `pom.xml` contains the correct version number
- ✅ `jitpack.yml` is properly configured for Java 17

Example `jitpack.yml` configuration:

```yaml
jdk:
  - openjdk17
```

### Release Process

#### 1. Update the Version

Update the version in `pom.xml`:

```xml
<version>1.98.1</version>
```

Commit and push the changes:

```bash
git commit -am "Bump version to 1.98.1"
git push
```

#### 2. Merge to Main

Create a pull request and merge into `main` after CI passes.

#### 3. Create and Push Git Tag

From the updated `main` branch:

```bash
git checkout main
git pull
git tag 1.98.1
git push origin 1.98.1
```

**Note:** The tag name must match the version used by consumers.

#### 4. Trigger JitPack Build

Open the project page to trigger the build:

```text
https://jitpack.io/#rspace-os/rspace-client-java-model/1.98.1
```

This forces JitPack to:

- Fetch the tag from GitHub
- Build the project
- Publish the artifacts

#### 5. Verify the Build

Check the build log for successful completion:

```text
https://jitpack.io/com/github/rspace-os/rspace-client-java-model/1.98.1/build.log
```

Ensure it ends with:

```text
BUILD SUCCESS
```

You can also verify on the artifact page:

```text
https://jitpack.io/#rspace-os/rspace-client-java-model/1.98.1
```

#### 6. Update Consumer Projects

In consuming projects, update the dependency:

```xml
<dependency>
    <groupId>com.github.rspace-os</groupId>
    <artifactId>rspace-client-java-model</artifactId>
    <version>1.98.1</version>
</dependency>
```

Ensure the JitPack repository is included:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then refresh dependencies:

```bash
mvn clean verify -U
```

## Versioning

Version numbering follows the RSpace API version. For example, 1.1.x versions will all support API 1.1. This library maintains backwards compatibility with earlier versions.

## Design & Architecture

### Project Lombok

This project uses [Project Lombok](https://projectlombok.org/) which adds getters/setters and constructors through bytecode manipulation. If you want to see these methods in your IDE, please consult the Lombok website for setup instructions.

### JSON Serialization

The project has minimal dependencies on Jackson libraries, leaving you free to choose your own JSON converter to convert these objects to/from JSON. JSON serialization has been tested using Jackson 2.8.

If you use Jackson, please configure your `ObjectMapper` to convert Enum classes as follows:

```java
ObjectMapper mapper = new ObjectMapper();
mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Ensure all tests pass
6. Submit a pull request

## License

See [LICENSE](LICENSE) file for details.

## Support

For issues and questions, please use the [GitHub Issues](https://github.com/rspace-os/rspace-client-java-model/issues) page.
