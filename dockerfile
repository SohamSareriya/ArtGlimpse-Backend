# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-alpine
ENV SPRING_PROFILES_ACTIVE=prod
WORKDIR /app
# Copy the JAR from builder stage (matches target/*.jar)
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["sh","-c","java -jar app.jar --spring.profiles.active=prod"]

