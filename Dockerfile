FROM maven:3.8.5-openjdk-17
COPY . .
RUN mvn clean package -DskipTest

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/caresolution-0.0.1.jar caresolution.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "caresolution.jar"]