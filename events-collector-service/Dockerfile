FROM gradle:8.14-jdk24 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean bootJar -x test

FROM eclipse-temurin:24-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/appl.jar appl.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "appl.jar"]
