FROM maven:3.8.4 AS build

COPY src src
COPY pom.xml pom.xml
RUN --mount=type=cache,target=/root/.m2,rw mvn -DskipTests clean package

FROM openjdk:17-alpine

COPY --from=build target/*.jar backend.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","backend.jar", \
  "--spring.datasource.url=jdbc:postgresql://database:5432/postgres", \
  "--spring.datasource.username=postgres", \
  "--spring.datasource.password=postgres"]
