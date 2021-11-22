FROM gradle:7.3.0-jdk8 AS build
COPY --chown=gradle:gradle main/docker /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:8

EXPOSE 8101

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/microservice-bank-0.0.1-SNAPSHOT.jar /app/microservice-bank.jar

ENTRYPOINT ["java","-jar","/app/microservice-bank.jar"]