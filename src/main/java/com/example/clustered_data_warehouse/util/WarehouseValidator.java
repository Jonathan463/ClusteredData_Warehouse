package com.example.clustered_data_warehouse.util;
import com.example.clustered_data_warehouse.request.WarehouseRequest;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class WarehouseValidator {



    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }

    public static boolean isValidDealUniqueId(String dealUniqueId) {
        return dealUniqueId != null && !dealUniqueId.isEmpty();
    }

    public static boolean isValidOrderingCurrency(String orderingCurrency) {
        return orderingCurrency != null && !orderingCurrency.isEmpty();
    }

    public static boolean isValidIsoCode(String isoCode) {
        return isoCode != null && !isoCode.isEmpty();
    }

    public static boolean isValidDealTimestamp(String dealTimestamp) {
        return dealTimestamp != null && !dealTimestamp.isEmpty();
    }

    public static boolean isValidAmount(String amount) {
        return amount != null && isValidNumericAmount(amount);
    }

    private static boolean isValidNumericAmount(String amount) {
        try {
            Double.parseDouble(amount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isValid(WarehouseRequest request) {
        return WarehouseValidator.isValidDealUniqueId(request.getDealUniqueId()) &&
                WarehouseValidator.isValidOrderingCurrency(request.getOrderingCurrency()) &&
                WarehouseValidator.isValidIsoCode(request.getIsoCode()) &&
                WarehouseValidator.isValidAmount(request.getAmount());
    }
}
