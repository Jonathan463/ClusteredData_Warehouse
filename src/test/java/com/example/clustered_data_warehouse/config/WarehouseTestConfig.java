package com.example.clustered_data_warehouse.config;

import com.example.clustered_data_warehouse.ClusteredDataWarehouseApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestOperations;

@Configuration
@Import({ClusteredDataWarehouseApplication.class})
public class WarehouseTestConfig {


    @Bean
    RestOperations restOperations(final RestTemplateBuilder builder) {
        return builder
                .build();
    }
}
