FROM java:jdk-alpine

ARG consulhost

ENV CONSUL_HOST=consulhost

WORKDIR /app

USER daemon

ADD ./build/libs/arguments-1-SNAPSHOT-all.jar /app/arguments-1-SNAPSHOT-all.jar

CMD [ "java", "-jar", "/app/arguments-1-SNAPSHOT-all.jar" ]

EXPOSE 5050