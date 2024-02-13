# Read Me First

Example project spring boot with docker and make file

The following was discovered as part of building this project:

* The original package name 'com.example.test-aws-services' is invalid and this project uses 'com.example.testawsservices' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)

### Docker commands

create docker image

docker build --build-arg JAR_FILE=target/test-aws-services-0.0.1-SNAPSHOT.jar -t abelo003/test-aws-service:v1 .

run docker image

docker run -d -p 8080:8080 abelo003/test-aws-service:v1 .

delete docker image

docker rmi abelo003/test-aws-service:v1

show docker containers

docker ps

stop docker container

docker stop container_id

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

