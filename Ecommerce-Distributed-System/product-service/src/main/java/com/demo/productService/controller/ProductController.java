package com.demo.productService.controller;

import com.demo.productService.model.ProductAvailability;
import com.demo.productService.resilence.ResilienceService;
import com.demo.productService.response.ProductResponse;
import com.demo.productService.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private IProductService productService;
    private final ResilienceService resilienceService;

    @Operation(summary = "Get a products by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the products",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "products not found",
                    content = @Content) })
    @GetMapping("/{uniqueId}")
    public ResponseEntity<List<ProductAvailability>> getProductDetailsByUniqueId(@PathVariable String uniqueId){
        List<ProductAvailability> productDetails = resilienceService.getProductDetails(uniqueId);
        return  new ResponseEntity<>(productDetails, !productDetails.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
