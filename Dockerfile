FROM openjdk:17-jdk
WORKDIR /app
COPY target/unbhelp-backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENV DB_HOST=db
ENV DB_PORT=5432
ENV DB_NAME=unbhelp
ENV DB_USER=postgres
ENV DB_PASSWORD=123456

CMD ["java", "-jar", "unbhelp-backend-0.0.1-SNAPSHOT.jar"]