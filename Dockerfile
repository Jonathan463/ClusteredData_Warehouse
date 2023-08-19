FROM openjdk:17-jdk-alphine
ADD target/clustered-data-warehouse.jar clustered-data-warehouse.jar
EXPOSE 8080
CMD ["java", "-jar", "clustered-data-warehouse.jar"]