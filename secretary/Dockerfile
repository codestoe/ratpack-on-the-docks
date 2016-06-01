FROM java:jdk-alpine

WORKDIR /app

USER daemon

ADD ./build/libs/secretary-1-SNAPSHOT-all.jar /app/secretary-1-SNAPSHOT-all.jar

CMD [ "java", "-jar", "/app/secretary-1-SNAPSHOT-all.jar" ]

EXPOSE 5050