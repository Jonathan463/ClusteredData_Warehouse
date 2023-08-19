FROM eclipse-temurin:17-alpine
ADD target/clustered-data-warehouse.jar clustered-data-warehouse.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "clustered-data-warehouse.jar"]
CMD ["--spring.datasource.url=${SPRING_DATASOURCE_URL}","--spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}","--spring.datasource.username=${SPRING_DATASOURCE_USERNAME}"]