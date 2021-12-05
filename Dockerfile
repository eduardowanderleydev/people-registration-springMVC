FROM openjdk:11

WORKDIR /app

COPY target/people-registration.jar /app/people-registration.jar

ENTRYPOINT ["java", "-jar", "people-registration.jar"]