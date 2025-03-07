# Use a multi-stage build

# Stage 1: Build the application
FROM maven:3.8.7-jdk-17-slim AS builder  # Use a Maven-enabled image
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
# Or the port your app uses
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]