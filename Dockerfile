FROM maven:3.5-jdk-8-alpine

COPY src /usr/src/src

COPY pom.xml /usr/src

RUN mvn -f /usr/src/pom.xml clean package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/src/target/ricettario-0.0.1-SNAPSHOT.jar"]
