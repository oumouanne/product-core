FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/product-core-0.3.0.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]