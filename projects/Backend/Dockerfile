FROM maven:3.6-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=/home/app/target/backend-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
