package com.example.clustered_data_warehouse.service;

import com.example.clustered_data_warehouse.model.Warehouse;
import com.example.clustered_data_warehouse.request.WarehouseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface WarehouseService {
    ResponseEntity<?> addClusteredData(WarehouseRequest request);
}
