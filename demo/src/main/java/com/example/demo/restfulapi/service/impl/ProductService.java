package com.example.demo.restfulapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.CartDto;
import com.example.demo.restfulapi.dto.ProductDto;
import com.example.demo.restfulapi.dto.StaffDto;
import com.example.demo.restfulapi.mapper.ProductMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.extra.BestSellingProductIds;
import com.example.demo.restfulapi.model.Product;
import com.example.demo.restfulapi.repository.ProductRepository;
import com.example.demo.restfulapi.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	private ResponseMessage responseMessage = new ResponseMessage();
	
	// private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	@Override
	public ResponseEntity<?> getAllProducts() {
		try {
			List<Product> allProducts = productRepository.findAll();
			ResponseCustom<List<ProductDto>> res = new ResponseCustom<List<ProductDto>>(productMapper.entityToDto(allProducts),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
	
	@Override
	public ResponseEntity<?> getNewestProducts() {
		try {
			List<Product> allProducts = productRepository.NewestProductList();
			ResponseCustom<List<ProductDto>> res = new ResponseCustom<List<ProductDto>>(productMapper.entityToDto(allProducts),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
	
	@Override
	public ResponseEntity<?> getBestSellingProducts() {
		try {
			List<BestSellingProductIds> bestSellingProductIds = productRepository.BestSellingProductList();
			
			List<ProductDto> bestSellingProductDtoList = new ArrayList<>();
			for(BestSellingProductIds bestSellingProductId: bestSellingProductIds) {
				Product product = productRepository.findById(bestSellingProductId.getproductId()).orElseThrow();
				bestSellingProductDtoList.add(productMapper.entityToDto(product));
			}
			
			ResponseCustom<List<ProductDto>> res = new ResponseCustom<List<ProductDto>>(bestSellingProductDtoList,
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
	
	@Override
	public ResponseEntity<?> getProductById(Long productId) {
		try {
			Product product = productRepository.findById(productId).orElseThrow();
			ResponseCustom<ProductDto> res = new ResponseCustom<ProductDto>(productMapper.entityToDto(product),
					responseMessage.GET_ITEM_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	public ResponseEntity<?> createProduct(ProductDto newProductDto) {
		try {
			Product newProduct = productRepository.save(productMapper.dtoToEntity(newProductDto));
			ResponseCustom<ProductDto> res = new ResponseCustom<ProductDto>(productMapper.entityToDto(newProduct),
					responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> deleteProduct(Long productId) {
		try {
			Product deleteProduct = productRepository.findById(productId).orElseThrow();
			productRepository.delete(deleteProduct); // this function return void
			ResponseCustom<ProductDto> res = new ResponseCustom<>(productMapper.entityToDto(deleteProduct),
					responseMessage.DELETE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> updateProduct(Long productId, ProductDto updateProductDto) {
		try {
			productRepository.findById(productId).orElseThrow();
			Product updateProduct = productRepository.save(productMapper.dtoToEntity(updateProductDto));
			ResponseCustom<ProductDto> res = new ResponseCustom<>(productMapper.entityToDto(updateProduct),
					responseMessage.UPDATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}
}
