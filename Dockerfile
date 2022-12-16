FROM openjdk:8
MAINTAINER baeldung.com
ADD target/ phoneContactsApp-0.0.1-SNAPSHOT.jar  phoneContactsApp.jar
ENTRYPOINT ["java","-jar","/phoneContactsApp-0.0.1-SNAPSHOT.jar"]