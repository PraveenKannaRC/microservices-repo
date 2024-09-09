package com.demo.productService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductAvailability {
    private  Long id;
    private String uniqId;
    private String isAvailabilityStatus;
}
