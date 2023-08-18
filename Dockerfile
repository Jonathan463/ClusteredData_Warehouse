# Use a base image with Java
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/your-service.jar your-service.jar

# Expose the port your service will run on
EXPOSE 8080

# Command to run your service
CMD ["java", "-jar", "your-service.jar"]