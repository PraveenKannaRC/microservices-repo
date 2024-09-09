package com.demo.catalogService.response;

public record ErrorResponse(int status, String message, long timestamp) {
};
