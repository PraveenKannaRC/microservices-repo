package com.demo.productService.response;

public record ErrorResponse (int status, String message, long timestamp) {
};
