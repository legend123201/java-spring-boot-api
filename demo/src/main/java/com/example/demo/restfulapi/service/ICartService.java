package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.model.request.CreateCartRequest;

public interface ICartService {
	ResponseEntity<?> getCartsByUserId(Long userId);
	ResponseEntity<?> createCart(CreateCartRequest createCartRequest); 
	ResponseEntity<?> deleteCart(Long userId, Long productId); 
	ResponseEntity<?> updateCart(Long userId, Long productId, Long quantity); 
}
