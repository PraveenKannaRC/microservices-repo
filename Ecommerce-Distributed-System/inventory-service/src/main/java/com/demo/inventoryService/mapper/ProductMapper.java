package com.demo.inventoryService.mapper;

import com.demo.inventoryService.model.ProductAvailability;
import com.demo.inventoryService.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse changeProductToProductResponse(ProductAvailability Product);
}

