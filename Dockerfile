## Use an official OpenJDK runtime as a parent image
#FROM eclipse-temurin:17-jdk-jammy
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the JAR file into the container
#COPY target/cookshare-0.0.1-SNAPSHOT.jar app.jar
#
## Expose the port your app runs on
#EXPOSE 8080
#
## Command to run the application
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Use a multi-stage build

# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080 # Or the port your app uses
CMD ["java", "-jar", "app.jar"]