FROM java:jdk-alpine

WORKDIR /app

USER daemon

ADD ./build/libs/abuse-1-SNAPSHOT-all.jar /app/abuse-1-SNAPSHOT-all.jar

CMD [ "java", "-jar", "/app/abuse-1-SNAPSHOT-all.jar" ]

EXPOSE 5050