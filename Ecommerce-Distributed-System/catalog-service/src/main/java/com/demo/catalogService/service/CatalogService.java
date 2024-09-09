package com.demo.catalogService.service;

import com.demo.catalogService.exception.ProductNotFoundException;
import com.demo.catalogService.model.Product;
import com.demo.catalogService.repository.CatalogRepository;
import com.demo.catalogService.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService {


    private  final CatalogRepository catalogRepository;


    public String saveProduct(Product product){
        if(catalogRepository.save(product)!=null);{
            return "product created successfully";
        }
    }
    public ProductResponse getProductDetailsById(String id){
        Product product=catalogRepository.findProductByUniqId(id);
        if(product==null){
            throw new ProductNotFoundException("Product not found", HttpStatus.NOT_FOUND);
        }
        return new ProductResponse(product);
    }
    public List<ProductResponse> getProductDetailsBySku(String sku){
        List<Product> productList = catalogRepository.getProductBySku(sku);
        return productList.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }
}
