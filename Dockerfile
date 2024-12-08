# Stage 1: Build Stage
FROM maven:3.9.9-eclipse-temurin-23 AS builder

WORKDIR /app

# Copy pom.xml and resolve dependencies first
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY . .
RUN mvn clean install -DskipTests

# Stage 2: Runtime Stage
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]