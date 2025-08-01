package com.hemant.jobapp.exception;

import com.hemant.jobapp.dto.ApiResponse;
import com.hemant.jobapp.dto.ResponseStructure;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseStructure<Object>> handleIllegalArgument(IllegalArgumentException e) {
        return ApiResponse.error(null, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseStructure<Object>> handleNullPointer(NullPointerException e) {
        return ApiResponse.error(null, "Something was null!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<ResponseStructure<Object>> handleResourceNotFound(ConfigDataResourceNotFoundException e) {
        return ApiResponse.error(null, e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class) // fallback handler
    public ResponseEntity<ResponseStructure<Object>> handleGeneralException(Exception e) {
        return ApiResponse.error(null, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

