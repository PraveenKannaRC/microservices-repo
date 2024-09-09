package com.demo.catalogService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "jcpenney_com-ecommerce_sample")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(length = 1062)
    private String Reviews;
}
