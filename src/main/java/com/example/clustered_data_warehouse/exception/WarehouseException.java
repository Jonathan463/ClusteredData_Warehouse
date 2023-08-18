package com.example.clustered_data_warehouse.exception;

public class WarehouseException extends RuntimeException{
    public WarehouseException(String message) {
        super(message);
    }

    public WarehouseException(String message, Throwable cause) {
        super(message, cause);
    }
}
