package com.demo.productService.resilence;

import com.demo.productService.exception.ServiceUnavailableException;
import com.demo.productService.feignclient.CatalogFeign;
import com.demo.productService.feignclient.InventoryFeign;
import com.demo.productService.model.ProductAvailability;
import com.demo.productService.response.ProductResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResilienceService {
    private final CatalogFeign catalogFeign;
    private final InventoryFeign inventoryFeign;
    @CircuitBreaker(name = "catalog-service", fallbackMethod = "fallbackProductDetails")
    @Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public List<ProductAvailability> getProductDetails(String uniqueId) {
        ResponseEntity<ProductResponse> productResponseResponseFromCatalog = catalogFeign.getTheProductDetailsByUnqueId(uniqueId);
        ProductResponse productResponse = productResponseResponseFromCatalog.getBody();
        if (productResponse != null) {
            ResponseEntity<ProductAvailability> productDetailsResponseFromInventory = inventoryFeign.getInventoryByUniqId(uniqueId);
            ProductAvailability availableProduct = productDetailsResponseFromInventory.getBody();
            if(availableProduct != null && availableProduct.getIsAvailabilityStatus().equals("AVAILABLE")) {
                List<ProductAvailability> productAvailabilities = new ArrayList<>();
                productAvailabilities.add(availableProduct);
                return productAvailabilities;
            }

        }
        return Collections.emptyList();
    }
    public List<ProductAvailability> fallbackProductDetails(String uniqueId, Throwable t) {
        log.error("Error = " + t);
        throw new ServiceUnavailableException("Service is unavailable currently", HttpStatus.SERVICE_UNAVAILABLE);
//        return Collections.emptyList();
    }
}