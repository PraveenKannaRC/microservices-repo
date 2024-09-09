package com.demo.productService.service;

import com.demo.productService.response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getProductDetailsByUniqueId(String uniqueId);
}
