FROM maven:3.9.9-amazoncorretto-17-debian

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY resources ./resources

RUN mvn clean package -Pprod
RUN mv ./target/*.jar ./jira.jar
RUN rm -rf ./target

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/jira.jar", "--spring.profiles.active=prod"]
