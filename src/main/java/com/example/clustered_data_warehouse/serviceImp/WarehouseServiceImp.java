package com.example.clustered_data_warehouse.serviceImp;

import com.example.clustered_data_warehouse.exception.WarehouseException;
import com.example.clustered_data_warehouse.model.Warehouse;
import com.example.clustered_data_warehouse.repository.WareHouseRepository;
import com.example.clustered_data_warehouse.request.WarehouseRequest;
import com.example.clustered_data_warehouse.response.CustomResponseHandler;
import com.example.clustered_data_warehouse.service.WarehouseService;
import com.example.clustered_data_warehouse.util.WarehouseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@Slf4j
public class  WarehouseServiceImp implements WarehouseService {

    private final WareHouseRepository wareHouseRepository;

    public WarehouseServiceImp(WareHouseRepository wareHouseRepository) {
        this.wareHouseRepository = wareHouseRepository;
    }


    @Override
    public ResponseEntity<?> addClusteredData(WarehouseRequest request) {

        String successfulResponse = "Saved Successfully";
        String failedResponse = "Failed to Save Record";
        if(WarehouseValidator.isValid(request)) {
            BigDecimal amount = new BigDecimal(request.getAmount());
            try {
            String currentDate = wareHouseRepository.getCurrentDate();
            Warehouse warehouse = Warehouse.builder()
                    .amount(amount)
                    .dealUniqueId(request.getDealUniqueId())
                    .isoCode(request.getIsoCode())
                    .orderingCurrency(request.getOrderingCurrency())
                    .dealTimestamp(currentDate).build();


                wareHouseRepository.save(warehouse);
                return CustomResponseHandler.responseBuilder(successfulResponse, String.valueOf(HttpStatus.ACCEPTED.value()));
            } catch (Exception exception) {
                log.info("Failed to save record. caused by " + exception.getMessage());
                throw new WarehouseException("Error saving warehouse data", exception);
            }

        }
        else{
            return CustomResponseHandler.responseBuilder(failedResponse, String.valueOf(HttpStatus.BAD_REQUEST.value()));
        }
    }
}
