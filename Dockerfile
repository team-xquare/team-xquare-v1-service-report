FROM openjdk:17.0.1-jdk-slim

EXPOSE 8080

RUN apt-get update && \
    apt-get install -y curl && \
    curl -sSLo koin https://github.com/InsertKoinIO/koin/releases/tag/ktor-3.4.0 && \
    chmod +x koin && \
    mv koin /usr/local/bin && \
    apt-get update && \
    apt-get install -y --no-install-recommends apt-utils

COPY build/libs/*.jar app.jar

ARG DB_URL
ENV DB_URL ${DB_URL}
ARG DB_DRIVER
ENV DB_DRIVER ${DB_DRIVER}
ARG DB_USERNAME
ENV DB_USERNAME ${DB_USERNAME}
ARG DB_PASSWORD
ENV DB_PASSWORD ${DB_PASSWORD}

ENTRYPOINT ["sh", "-c", "java -jar -Duser.timezone=Asia/Seoul /app.jar && echo \"Starting KoinApplication\" && java -classpath /app.jar xquare.com.Application.kt"]
