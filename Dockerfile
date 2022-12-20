FROM openjdk:8
MAINTAINER mansi
COPY target/contact-App.jar contact-App.jar
ENTRYPOINT ["java","-jar","/contact-App.jar"]
EXPOSE:8080