FROM maven:3.9.0-openjdk-17 AS build

WORKDIR /app

# Copiar pom.xml primero para cache de dependencias
COPY pom.xml .

# Descargar dependencias
RUN mvn dependency:go-offline -B

# Copiar código fuente
COPY src ./src

# Compilar sin tests
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar JAR compilado
COPY --from=build /app/target/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Comando de inicio
CMD ["java", "-Dserver.port=${PORT:-8080}", "-jar", "app.jar"]