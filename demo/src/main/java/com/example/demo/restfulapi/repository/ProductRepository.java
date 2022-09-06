package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Product;
import com.example.demo.restfulapi.model.extra.BestSellingProductIds;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value = "SELECT * FROM product ORDER BY id DESC LIMIT 10", nativeQuery = true)
	List<Product> NewestProductList();
	
	@Query(value = "SELECT product_id as productId, COUNT(product.id) AS total\r\n"
			+ "FROM product, bill_detail\r\n"
			+ "WHERE product.id = bill_detail.product_id\r\n"
			+ "GROUP BY product.id\r\n"
			+ "ORDER BY total DESC\r\n"
			+ "LIMIT 10", nativeQuery = true)
	List<BestSellingProductIds> BestSellingProductList();
}
