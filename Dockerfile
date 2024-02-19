FROM openjdk:8-jre-alpine
EXPOSE 80
ARG JAR_FILE=target/test-aws-services-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} test-aws-services.jar
ENTRYPOINT ["java", "-jar", "/test-aws-services.jar"]