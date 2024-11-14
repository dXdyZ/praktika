# Используем официальный образ OpenJDK для Java 17
FROM openjdk:17-jdk-slim

# Устанавливаем переменную окружения для порта
ENV PORT=8080

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем собранный JAR-файл в контейнер
COPY build/libs/suit-0.0.1-SNAPSHOT.jar app.jar

# Устанавливаем ngrok
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://bin.equinox.io/c/bNyj1mQVY4c/ngrok-stable-linux-amd64.zip && \
    unzip ngrok-stable-linux-amd64.zip -d /usr/local/bin && \
    rm ngrok-stable-linux-amd64.zip

# Укажите здесь ваш ngrok токен
ENV NGROK_AUTHTOKEN=2omqgqFxlDUPVOQjF6n6xIxTUNW_7G2ao37YSQHM1NPdKFGf5

# Экспонируем порт приложения
EXPOSE 8080

# Запускаем приложение и ngrok
CMD java -jar app.jar & \
    ngrok http $PORT --log=stdout
