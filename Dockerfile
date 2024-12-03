FROM eclipse-temurin:21-jdk-alpine as builder

WORKDIR /app

COPY gradlew gradlew.bat /app/
COPY gradle /app/gradle/
COPY build.gradle settings.gradle /app/
COPY src /app/src

RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

RUN ls -la build/libs

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-csvpkb3qf0us73fv8lhg-a.oregon-postgres.render.com:5432/back_tech_db_mmdm
ENV SPRING_DATASOURCE_USERNAME=ussser
ENV SPRING_DATASOURCE_PASSWORD=1XtU6j3XRO8yzLUIfz89QQjZd6b4qcWD
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DEFAULT_SCHEMA=backend-technologies
ENV SPRING_FLYWAY_ENABLED=true
ENV SPRING_FLYWAY_LOCATIONS=classpath:db/migration

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
