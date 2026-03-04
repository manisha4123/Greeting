#
# Build stage
#
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /home/app
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
WORKDIR /usr/local/lib
COPY --from=build /home/app/target/greeting-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java","-jar","app.jar"]
