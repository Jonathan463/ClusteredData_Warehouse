package com.example.clustered_data_warehouse;

import com.example.clustered_data_warehouse.exception.WarehouseException;
import com.example.clustered_data_warehouse.model.Warehouse;
import com.example.clustered_data_warehouse.repository.WareHouseRepository;
import com.example.clustered_data_warehouse.request.WarehouseRequest;
import java.util.Map;
import java.util.UUID;

import com.example.clustered_data_warehouse.serviceImp.WarehouseServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class WarehouseServiceImpTest {

    @Mock
    private WareHouseRepository wareHouseRepository;

    @InjectMocks
    private WarehouseServiceImp warehouseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddClusteredData_Success() {
        // Arrange
        WarehouseRequest request = new WarehouseRequest(UUID.randomUUID().toString(), "EUR", "EUR", "1000.0");
        when(wareHouseRepository.getCurrentDate()).thenReturn("18-AUG-23");

        // Act
        ResponseEntity<?> response = warehouseService.addClusteredData(request);

        // Assert
        verify(wareHouseRepository, times(1)).save(any(Warehouse.class));
        assertThat(response).satisfies(i -> {
            assertThat(i.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
            assertThat(i.getBody()).isEqualTo(Map.of("responseMessage", "Saved Successfully", "responseCode", "400"));
        });
        // Add more assertions for the response if needed
    }

    @Test
    void testAddClusteredData_InvalidRequest() {
        // Arrange
        WarehouseRequest invalidRequest = new WarehouseRequest();
        when(wareHouseRepository.getCurrentDate()).thenReturn("18-AUG-23");

        // Act
        ResponseEntity<?> response = warehouseService.addClusteredData(invalidRequest);

        // Assert
        assertThat(response).satisfies(i -> {
            assertThat(i.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
            assertThat(i.getBody()).isEqualTo(Map.of("responseMessage", "Failed to Save Record", "responseCode", "400"));
        });
        // Add assertions for the response if needed
        verifyNoInteractions(wareHouseRepository);
    }

    @Test
    void testAddClusteredData_SaveFailure() {
        // Arrange
        WarehouseRequest request = new WarehouseRequest(UUID.randomUUID().toString(), "EUR", "EUR", "1000.0");
        when(wareHouseRepository.getCurrentDate()).thenReturn("18-AUG-23");
        when(wareHouseRepository.save(any(Warehouse.class))).thenThrow(new RuntimeException("Save failed"));

        // Act and Assert
        assertThatExceptionOfType(WarehouseException.class)
                .isThrownBy(() -> warehouseService.addClusteredData(request))
                .withMessageContaining("Error saving warehouse data");
        // Add assertions for exception handling in the service method
 }
}


