package com.example.demo.restfulapi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.restfulapi.dto.ProductDto;
import com.example.demo.restfulapi.service.IProductService;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long productId) {
		return productService.getProductById(productId);
	}

	@PostMapping("")
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto newProductDto) {
		return productService.createProduct(newProductDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
		return productService.deleteProduct(productId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody ProductDto updateProductDto ) {
		return productService.updateProduct(productId, updateProductDto);
	}
}