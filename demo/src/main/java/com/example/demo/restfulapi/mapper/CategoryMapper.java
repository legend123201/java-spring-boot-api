package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.CategoryDto;
import com.example.demo.restfulapi.model.Category;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class CategoryMapper extends GenericMapper<Category, CategoryDto> {
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Category dtoToEntity(CategoryDto categoryDto) {
		return modelMapper.map(categoryDto, Category.class);
	}

	@Override
	public CategoryDto entityToDto(Category category) {
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> entityToDto(List<Category> categoryList) {
		Type listType = new TypeToken<List<CategoryDto>>() {
		}.getType();

		return modelMapper.map(categoryList, listType);
	}

	@Override
	public List<Category> dtoToEntity(List<CategoryDto> categoryDtoList) {
		Type listType = new TypeToken<List<Category>>() {
		}.getType();

		return modelMapper.map(categoryDtoList, listType);
	}
}
