package com.demo.productService.exception;

import com.demo.productService.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler  {
    @org.springframework.web.bind.annotation.ExceptionHandler(BaseApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(BaseApiException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.httpStatus.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(ex.httpStatus).body(errorResponse);
    }
}
