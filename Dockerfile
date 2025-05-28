FROM openjdk:alpine
LABEL authors="Sindicat"

WORKDIR /app

COPY target/spring-boot-docker.jar /app/BookLibrary-0.0.1-SNAPSHOT.jar

RUN mvn clean package

CMD ["java", "-jar", "BookLibrary-0.0.1-SNAPSHOT.jar"]
