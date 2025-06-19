# Use Eclipse Temurin base image for Java 17
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar file built by Maven into the image
COPY target/Authentication-API-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Railway will override this anyway)
EXPOSE 8080

# Command to run the Spring Boot app
CMD ["java", "-jar", "app.jar"]
