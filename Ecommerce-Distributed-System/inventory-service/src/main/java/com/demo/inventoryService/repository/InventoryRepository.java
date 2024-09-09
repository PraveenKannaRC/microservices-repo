package com.demo.inventoryService.repository;

import com.demo.inventoryService.model.ProductAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<ProductAvailability, Long> {
    Optional<ProductAvailability> findByUniqId(String uniqId);
}
