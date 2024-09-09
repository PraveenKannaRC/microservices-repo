package com.demo.catalogService.repository;

import com.demo.catalogService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Product, String> {
    @Query(value = "SELECT *FROM `jcpenney_com-ecommerce_sample` WHERE uniq_id = :uniqueId", nativeQuery = true )
    Product findProductByUniqId(@Param("uniqueId") String uniqueId);

    @Query(value = "SELECT *FROM `jcpenney_com-ecommerce_sample` WHERE sku =:sku",nativeQuery = true)
    List<Product> getProductBySku(@Param("sku")String sku);

}
