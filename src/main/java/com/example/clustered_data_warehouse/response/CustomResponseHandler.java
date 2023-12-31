package com.example.clustered_data_warehouse.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;

public class CustomResponseHandler {
    public static ResponseEntity<Map<String, String>> responseBuilder(String message, String httpStatus){

        Map<String, String> response = new HashMap<>();

        if(httpStatus.equals("202")){
            response.put("responseMessage", message);
            response.put("responseCode", "200");
        }
        else{
            response.put("responseMessage", message);
            response.put("responseCode", "400");
        }

        return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(httpStatus)));
 }
}

