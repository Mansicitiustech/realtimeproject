FROM openjdk:8
MAINTAINER baeldung.com
ADD target/phoneContactsApp-0.0.1-SNAPSHOT.jar phone-contact-app.jar

ENTRYPOINT ["java","-jar","phone-contact-app.jar"]
EXPOSE 8081