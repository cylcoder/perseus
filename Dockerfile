FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN apk add --no-available --no-cache tzdata && \
    cp /usr/share/zoneinfo/Asia/Seoul /etc/localtime && \
    echo "Asia/Seoul" > /etc/timezone

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]