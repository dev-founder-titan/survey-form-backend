FROM adoptopenjdk/openjdk11:latest

COPY target/form-0.0.1-SNAPSHOT.jar /usr/src/app/form.jar
WORKDIR /usr/src/app

CMD ["java","-jar","/usr/src/app/form.jar"]
EXPOSE 8080