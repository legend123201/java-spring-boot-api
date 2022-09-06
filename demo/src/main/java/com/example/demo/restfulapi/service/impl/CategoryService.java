package com.example.demo.restfulapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.StaffDto;
import com.example.demo.restfulapi.dto.CategoryDto;
import com.example.demo.restfulapi.mapper.CategoryMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.Category;
import com.example.demo.restfulapi.repository.CategoryRepository;
import com.example.demo.restfulapi.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryMapper categoryMapper;

	private ResponseMessage responseMessage = new ResponseMessage();
	
	// private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

	@Override
	public ResponseEntity<?> getAllCategorys() {
		try {
			List<Category> allCategorys = categoryRepository.findAll();
			ResponseCustom<List<CategoryDto>> res = new ResponseCustom<List<CategoryDto>>(categoryMapper.entityToDto(allCategorys),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
	
	@Override
	public ResponseEntity<?> createCategory(CategoryDto newCategoryDto) {
		try {
			Category newCategory = categoryRepository.save(categoryMapper.dtoToEntity(newCategoryDto));
			ResponseCustom<CategoryDto> res = new ResponseCustom<CategoryDto>(categoryMapper.entityToDto(newCategory),
					responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> deleteCategory(Long categoryId) {
		try {
			Category deleteCategory = categoryRepository.findById(categoryId).orElseThrow();
			categoryRepository.delete(deleteCategory); // this function return void
			ResponseCustom<CategoryDto> res = new ResponseCustom<>(categoryMapper.entityToDto(deleteCategory),
					responseMessage.DELETE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> updateCategory(Long categoryId, CategoryDto updateCategoryDto) {
		try {
			categoryRepository.findById(categoryId).orElseThrow();
			Category updateCategory = categoryRepository.save(categoryMapper.dtoToEntity(updateCategoryDto));
			ResponseCustom<CategoryDto> res = new ResponseCustom<>(categoryMapper.entityToDto(updateCategory),
					responseMessage.UPDATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}
}
