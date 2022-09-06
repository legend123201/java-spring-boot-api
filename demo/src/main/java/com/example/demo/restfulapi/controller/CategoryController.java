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
import com.example.demo.restfulapi.dto.CategoryDto;
import com.example.demo.restfulapi.model.request.LoginRequest;
import com.example.demo.restfulapi.service.ICategoryService;

@RestController
@RequestMapping("api/v1/categorys")
@CrossOrigin
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("")
	public ResponseEntity<?> getAllCategorys() {
		return categoryService.getAllCategorys();
	}

	@PostMapping("")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto newCategoryDto) {
		return categoryService.createCategory(newCategoryDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long categoryId) {
		return categoryService.deleteCategory(categoryId);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable(value = "id") Long categoryId,
			@Valid @RequestBody CategoryDto updateCategoryDto) {
		return categoryService.updateCategory(categoryId, updateCategoryDto);
	}
}