package com.demo.inventoryService.controller;

import com.demo.inventoryService.model.ProductAvailability;
import com.demo.inventoryService.service.ProductAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final ProductAvailabilityService productAvailabilityService;

    @GetMapping("/{uniqId}")
    public ResponseEntity<ProductAvailability> getProductAvailabilityByUniqId(@PathVariable String uniqId) {
        return productAvailabilityService.getInventoryByUniqId(uniqId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/generate")
    public ResponseEntity<Void> generateRandomProductAvailability(@RequestBody Map<String, List<String>> body) {
        List<String> uniqIds = body.get("uniqIds");
        productAvailabilityService.generateRandomAvailability(uniqIds);
        return ResponseEntity.ok().build();
    }
}
