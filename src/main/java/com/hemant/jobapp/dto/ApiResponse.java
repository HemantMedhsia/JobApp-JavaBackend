package com.hemant.jobapp.dto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ApiResponse {
    public static <T> ResponseEntity<ResponseStructure<T>> success(T data, String message, HttpStatus statusCode){
        ResponseStructure<T> responseBody = ResponseStructure.<T>builder()
                .status("success")
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(statusCode).body(responseBody);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> error(T data, String message, HttpStatus statusCode){
        ResponseStructure<T> responseBody = ResponseStructure.<T>builder()
                .status("error")
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(statusCode).body(responseBody);
    }
}
