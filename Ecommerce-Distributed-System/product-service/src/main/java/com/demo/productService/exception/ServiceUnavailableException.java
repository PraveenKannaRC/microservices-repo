package com.demo.productService.exception;


import org.springframework.http.HttpStatus;

public class ServiceUnavailableException extends BaseApiException{

    public ServiceUnavailableException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}