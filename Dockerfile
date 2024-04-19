# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper files
COPY gradlew .
COPY gradle gradle

# Copy the project files and directories needed for dependency resolution
COPY build.gradle .
COPY settings.gradle .
COPY gradlew.bat .

# Copy the source code
COPY src src

# Run Gradle to build the Spring Boot application
RUN ./gradlew build

# Copy the packaged Spring Boot application JAR file into the container
COPY build/libs/your-spring-app.jar /app/your-spring-app.jar

# Expose the port that your Spring Boot application uses
EXPOSE 8080

# Run the Spring Boot application when the container launches
CMD ["java", "-jar", "your-spring-app.jar"]
