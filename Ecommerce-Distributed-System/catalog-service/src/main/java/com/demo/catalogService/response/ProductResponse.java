package com.demo.catalogService.response;

import com.demo.catalogService.model.Product;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String uniq_id;
    private String sku;
    private String name_title;
    private String description;
    private String list_price;
    private String sale_price;
    private String category;
    private String category_tree;
    private String average_product_rating;
    private String product_url;
    private String product_image_urls;
    private String brand;
    private String total_number_reviews;
    private String Reviews;
    private boolean isAvailable;


    public ProductResponse(Product productDetails) {
        this.uniq_id = productDetails.getUniq_id();
        this.sku = productDetails.getSku();
        this.name_title = productDetails.getName_title();
        this.description = productDetails.getDescription();
        this.list_price = productDetails.getList_price();
        this.sale_price = productDetails.getSale_price();
        this.category = productDetails.getCategory();
        this.category_tree = productDetails.getCategory_tree();
        this.average_product_rating = productDetails.getAverage_product_rating();
        this.product_url = productDetails.getProduct_url();
        this.product_image_urls = productDetails.getProduct_image_urls();
        this.brand = productDetails.getBrand();
        this.total_number_reviews = productDetails.getTotal_number_reviews();
        this.Reviews = productDetails.getReviews();
    }
}
