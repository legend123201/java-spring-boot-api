package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.dto.ProductDto;

public interface IProductService {
	ResponseEntity<?> getAllProducts();
	ResponseEntity<?> createProduct(ProductDto newProductDto); 
	ResponseEntity<?> deleteProduct(Long productId); 
	ResponseEntity<?> updateProduct(Long productId, ProductDto updateProductDto); 
}
