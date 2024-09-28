# Usa una imagen base de Java
FROM openjdk:17-jdk-slim AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Construye el proyecto
RUN ./mvnw package -DskipTests

# Usa una imagen base más ligera para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado en la etapa de construcción
COPY --from=build /app/target/lciii-scaffolding-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
