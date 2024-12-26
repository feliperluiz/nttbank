FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/nttbank-0.0.1-SNAPSHOT.jar /app/nttbank.jar
EXPOSE 8080
CMD ["java", "-jar", "nttbank.jar"]