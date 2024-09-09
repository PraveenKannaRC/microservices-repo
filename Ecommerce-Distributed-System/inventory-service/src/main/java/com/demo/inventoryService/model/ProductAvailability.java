package com.demo.inventoryService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProductAvailability")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String uniqId;
    private String isAvailabilityStatus;
}
