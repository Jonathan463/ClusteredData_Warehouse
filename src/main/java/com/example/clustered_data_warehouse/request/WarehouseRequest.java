package com.example.clustered_data_warehouse.request;

import lombok.*;

import java.math.BigDecimal;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseRequest {
    @NotEmpty(message = "Deal unique ID cannot be empty")
    private String dealUniqueId;
    @NotEmpty(message = "Ordering currency cannot be empty")
    @Size(min = 3, max = 3, message = "Ordering currency must be exactly 3 characters")
    private String orderingCurrency;
    @NotEmpty(message = "ISO code cannot be empty")
    @Size(min = 2, max = 2, message = "ISO code must be exactly 2 characters")
    private String isoCode;
    @NotEmpty(message = "Amount cannot be empty")
    @DecimalMin(value = "0.01", inclusive = true, message = "Amount must be at least 0.01")
    private String amount;
}
