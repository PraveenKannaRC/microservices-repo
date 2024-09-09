package com.demo.catalogService.controller;

import com.demo.catalogService.response.ProductResponse;
import com.demo.catalogService.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService cataLogService;

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductResponse> getProductDetailsByUniqueId(@PathVariable("id") String id){
        ProductResponse productResponse=cataLogService.getProductDetailsById(id);
        return new ResponseEntity<>(productResponse, Objects.nonNull(productResponse)? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getProductBySku")
    public ResponseEntity<List<ProductResponse>> getProductBySku(@RequestParam String sku){
        List<ProductResponse> productResponse=cataLogService.getProductDetailsBySku(sku);
        return new ResponseEntity<>(productResponse,!productResponse.isEmpty()?HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
