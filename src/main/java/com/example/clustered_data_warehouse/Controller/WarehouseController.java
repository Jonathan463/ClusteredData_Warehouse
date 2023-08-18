package com.example.clustered_data_warehouse.Controller;

import com.example.clustered_data_warehouse.request.WarehouseRequest;
import com.example.clustered_data_warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clustered-data-warehouse")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;
    @PostMapping("/api/v1")
    public ResponseEntity<?> addData(@RequestBody WarehouseRequest warehouseRequest){
        return warehouseService.addClusteredData(warehouseRequest);
    }
}
