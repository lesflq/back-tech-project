FROM eclipse-temurin:21-jdk-alpine as builder

WORKDIR /app

COPY gradlew gradlew.bat /app/
COPY gradle /app/gradle/
COPY build.gradle settings.gradle /app/

RUN ./gradlew dependencies --no-daemon

COPY src /app/src

RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=root
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DEFAULT_SCHEMA=backend-technologies
ENV SPRING_FLYWAY_ENABLED=true
ENV SPRING_FLYWAY_LOCATIONS=classpath:db/migration

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
