FROM openjdk:23-jdk-slim


RUN mkdir /app

COPY /backend/*.jar /app/empik.jar

ENTRYPOINT ["java","-jar","/app/empik.jar"]