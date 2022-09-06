package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.dto.CategoryDto;

public interface ICategoryService {
	ResponseEntity<?> getAllCategorys();
	ResponseEntity<?> createCategory(CategoryDto newCategoryDto); 
	ResponseEntity<?> deleteCategory(Long categoryId); 
	ResponseEntity<?> updateCategory(Long categoryId, CategoryDto updateCategoryDto); 
}
