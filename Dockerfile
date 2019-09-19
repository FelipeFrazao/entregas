
FROM maven:alpine

COPY . /entregas
WORKDIR /entregas

RUN mvn clean install -DskipTests