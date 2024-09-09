package com.demo.productService.feignclient;

import com.demo.productService.model.ProductAvailability;
import com.demo.productService.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "inventory-service",url = "http://localhost:8083/api/inventory")
public interface InventoryFeign {

        @GetMapping("/{uniqId}")
        public ResponseEntity<ProductAvailability> getInventoryByUniqId(@PathVariable String uniqId) ;

}
