FROM openjdk:8-alpine as builder
WORKDIR /app/msvc-usuarios

COPY ./pom.xml /app
COPY ./msvc-usuarios/.mvn ./.mvn
COPY ./msvc-usuarios/pom.xml .
COPY ./msvc-usuarios/mvnw .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-usuarios/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:8-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

#ENTRYPOINT ["java","-jar","msvc-usuarios-0.0.1-SNAPSHOT.jar"]
CMD ["java","-jar","msvc-usuarios-0.0.1-SNAPSHOT.jar"]