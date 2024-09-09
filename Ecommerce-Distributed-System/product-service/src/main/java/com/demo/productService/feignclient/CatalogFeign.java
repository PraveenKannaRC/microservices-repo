package com.demo.productService.feignclient;


import com.demo.productService.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@FeignClient(name="catalog-service",  url = "http://localhost:8081/api/catalog")
public interface CatalogFeign {
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductResponse> getTheProductDetailsByUnqueId(@PathVariable("id") String id);

    @GetMapping("/getProductBySku")
    public ResponseEntity<List<ProductResponse>> getProductBySku(@RequestParam String sku);
}
