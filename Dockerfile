FROM openjdk:21-jdk-slim
WORKDIR /app
COPY ./build/libs/lw1-0.0.1-SNAPSHOT.jar /app/lw1-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/lw1-0.0.1-SNAPSHOT.jar"]
