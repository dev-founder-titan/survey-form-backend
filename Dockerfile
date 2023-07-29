FROM openjdk:11

COPY target/form-0.0.1-SNAPSHOT.jar /usr/src/app/form.jar
WORKDIR /usr/src/app

RUN java -jar form.jar
EXPOSE 8080