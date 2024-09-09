package com.demo.inventoryService.service;

import com.demo.inventoryService.model.ProductAvailability;
import com.demo.inventoryService.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor

public class ProductAvailabilityService {
    private final InventoryRepository inventoryRepository;



    public Optional<ProductAvailability> getInventoryByUniqId(String uniqId) {
        return inventoryRepository.findByUniqId(uniqId);
    }
    public void generateRandomAvailability(List<String> uniqIds) {
        Random random = new Random();
        for(String uniqId:uniqIds){
            ProductAvailability productAvailability = new ProductAvailability();
            productAvailability.setUniqId(uniqId);
            productAvailability.setIsAvailabilityStatus(random.nextBoolean()? "AVAILABLE":"NOT_AVAILABLE");
            inventoryRepository.save(productAvailability);
        }
    }
}
