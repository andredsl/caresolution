#Start with maven:3.8.7-eclipse-temurin-19-alpine base image
FROM openjdk:18-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the source code to the container
COPY . .

# Build the application with Maven
#RUN mvn package

# Expose default Spring Boot port
EXPOSE 8081

# Run the jar file
CMD ["java", "-jar", "target/Controle-financeiro-auth-0.0.1.jar"]

#End