FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

ENV TZ=Asia/Seoul

RUN apk add --no-cache tzdata

COPY build/libs/*.jar app.jar

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar app.jar"]