package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.ProductDto;
import com.example.demo.restfulapi.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ProductMapper extends GenericMapper<Product, ProductDto> {
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Product dtoToEntity(ProductDto productDto) {
		return modelMapper.map(productDto, Product.class);
	}

	@Override
	public ProductDto entityToDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> entityToDto(List<Product> productList) {
		Type listType = new TypeToken<List<ProductDto>>() {
		}.getType();

		return modelMapper.map(productList, listType);
	}

	@Override
	public List<Product> dtoToEntity(List<ProductDto> productDtoList) {
		Type listType = new TypeToken<List<Product>>() {
		}.getType();

		return modelMapper.map(productDtoList, listType);
	}
}
