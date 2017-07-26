# RSpace API client model

Java classes to model RSpace API entities to facilitate JVM-based clients using the RSpace API.
These classes provide type-safe creation of RSpace API entities. For creating objects to post, there
are useful builder methods to construct the request bodies.

E.g. to create a document to post:

    DocumentPost post = DocumentPost.builder().name("myDocument").tags("a,b,c")
      .field(new FieldPost("content1"))
      .field(new FieldPost("content2"))
      .field(new FieldPost("content3"))
      .field(FieldPost.emptyField())
      .form(new FormRef(23))
      .build();

## Using this project

Binaries are  available in Maven Central as 

    <dependency>
      <groupId>com.researchspace</groupId>
      <artifactId>rspace-client-java-model</artifactId>
      <version>1.1.1</version>
    </dependency>
    
 or as Gradle:
 
    compile 'com.researchspace:rspace-client-java-model:1.1.1'
    
 To build from source:
 
    ./gradlew clean test build
    
  will run tests and build a jar in the  `build` folder of this project. You don't need to install anything
   for this to work.
  
  
## Versioning
 
  Version numbering follows the RSpace API version. E.g.. 1.1.x versions will all support API 1.1.
  This library should be backwards compatible with earlier versions.
  
## Design

 This project uses Project Lombok which adds getters/setters and constructors through bytecode 
  manipulation. If you want to see these methods in your IDE, please consult the
   [Lombok website](https://projectlombok.org/) for how to do this.
   
  There are no dependencies on JSON libraries leaving you free to choose your own to convert these
  objects to/from JSON. JSON serialisation has been tested using Jackson 2.8. If you do use Jackson,
  please configure your ObjectMapper to convert Enum classes as follows:
  
      ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);