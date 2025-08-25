# 1. Этап сборки
FROM gradle:8.14-jdk24 AS builder

# Создаем рабочую директорию и копируем исходники
WORKDIR /app
COPY . .

# Собираем JAR (bootJar для Spring Boot)
RUN ./gradlew clean bootJar -x test

# 2. Этап выполнения
FROM eclipse-temurin:24-jdk

# Создаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR из предыдущего этапа
COPY --from=builder /app/build/libs/app.jar app.jar

# Прокидываем порт приложения
EXPOSE 8888

# Команда запуска
ENTRYPOINT ["java", "-jar", "app.jar"]