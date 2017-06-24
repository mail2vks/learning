FROM openjdk:8u131-jdk-alpine
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/hitcounter-0.0.1-SNAPSHOT.jar /app/hitCounter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/hitcounter-0.0.1-SNAPSHOT.jar"]