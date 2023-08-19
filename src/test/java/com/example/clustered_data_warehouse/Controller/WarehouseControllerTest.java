package com.example.clustered_data_warehouse.Controller;

import com.example.clustered_data_warehouse.ClusteredDataWarehouseApplication;
import com.example.clustered_data_warehouse.config.WarehouseTestConfig;
import com.example.clustered_data_warehouse.request.WarehouseRequest;
import com.example.clustered_data_warehouse.service.WarehouseService;
import java.net.URI;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port=8080"
)
@ContextConfiguration(
        classes = {
                WarehouseTestConfig.class
        }
)
@Testcontainers
class WarehouseControllerTest {

    @Container
    private static final PostgreSQLContainer<?> POSTGRES_CONTAINER = new PostgreSQLContainer<>(DockerImageName.parse("postgres:14-alpine3.18"))
            .withUsername("postgres")
            .withPassword("30496039")
            .withDatabaseName("ClusteredDataWarehouse")
            .withExposedPorts(5432);

    @Autowired
    private RestOperations restOperations;


    @Test
    void addData() {
        final WarehouseRequest warehouseRequest = new WarehouseRequest("0abfe0a6-3ead-11ee-be56-0242ac120006",
                "EUR",
                "USD",
                "150000.0"
        );
        final HttpEntity<WarehouseRequest> request = new HttpEntity<>(warehouseRequest);
        final ResponseEntity<Map<String, String>> exchange = restOperations.exchange(
                URI.create("http://localhost:8080/clustered-data-warehouse/api/v1"),
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<>() {
                }
        );

        System.out.println(exchange);
    }

    @DynamicPropertySource
    static void setPostgresContainer(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.password", POSTGRES_CONTAINER::getPassword);
        registry.add("spring.datasource.username", POSTGRES_CONTAINER::getUsername);
    }
}