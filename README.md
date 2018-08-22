# Spring Jetty Embedded Example
In my previous examples, I have been implementing the `maven-jetty-plugin` to execute the code. This example bundles
the Jetty servlet container into the application runtime, allowing distribution of a working server runtime requiring
just a compatible JRE.

This example uses no XML configuration, preferring Java configuration approach available with modern servlet
implementations.

## Preparing the example
To prepare the java application;
```bash
mvn package
```

This will produce a build artifact that you may execute as follows;
```bash
java -jar target/spring-jetty-embedded-DEV-SNAPSHOT-full.jar
```

## Accessing Example URIs
[Hello World Example](http://localhost:8080)