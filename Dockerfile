FROM gradle:7.3.0-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle clean bootJar --no-daemon 

FROM openjdk:8-jre-slim
EXPOSE 8080
COPY --from=build /home/gradle/build/libs/*.jar spring-boot-application.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","spring-boot-application.jar"]