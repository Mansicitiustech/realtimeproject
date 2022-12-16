FROM openjdk:8
MAINTAINER baeldung.com
COPY target/ phoneContactsApp-0.0.1-SNAPSHOT.jar  \C:\Users\MansiC\Documents\practice\my-skill-improvement 
WORKDIR \C:\Users\MansiC\Documents\practice\my-skill-improvement
ENTRYPOINT ["java","-jar","phoneContactsApp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081