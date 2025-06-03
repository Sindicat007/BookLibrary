FROM openjdk:alpine
LABEL authors="Sindicat"

WORKDIR /app

COPY BookLibrary-0.0.1-SNAPSHOT.jar /app/library.jar

RUN mvn clean package

ENTRYPOINT ["java", "-jar", "library.jar"]
