
FROM java
FROM maven:alpine

WORKDIR /app

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8181
EXPOSE 3306
LABEL maintainer="felipe.sfrazao@outlook.com"
ADD ./target/spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar"]