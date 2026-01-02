# 1️⃣ Base image (Java 17 required for Spring Boot 3+)
FROM eclipse-temurin:25-jre

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy your exact JAR into container
COPY target/webAppTodo-4.0.0.jar app.jar

# 4️⃣ Expose Spring Boot port
EXPOSE 8080

# 5️⃣ Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

