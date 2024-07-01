# Dockerfile
FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/*.jar /app/application.jar

CMD ["java", "-jar", "application.jar"]
