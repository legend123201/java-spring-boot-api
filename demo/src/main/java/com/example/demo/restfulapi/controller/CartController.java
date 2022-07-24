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
import com.example.demo.restfulapi.dto.CartDto;
import com.example.demo.restfulapi.model.request.CreateCartRequest;
import com.example.demo.restfulapi.model.request.UpdateCartRequest;
import com.example.demo.restfulapi.service.ICartService;

@RestController
@RequestMapping("api/v1/carts")
@CrossOrigin
public class CartController {

	@Autowired
	private ICartService cartService;

	@GetMapping("/userId/{userId}")
	public ResponseEntity<?> getCartsByUser(@PathVariable(value = "userId") Long userId) {
		return cartService.getCartsByUserId(userId);
	}

	@PostMapping("")
	public ResponseEntity<?> createCart(@Valid @RequestBody CreateCartRequest createCartRequest) {
		return cartService.createCart(createCartRequest);
	}

	@DeleteMapping("/userId/{userId}/productId/{productId}")
	public ResponseEntity<?> deleteCart(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "productId") Long productId) {
		return cartService.deleteCart(userId, productId);
	}

	@PutMapping("/userId/{userId}/productId/{productId}")
	public ResponseEntity<?> updateCart(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "productId") Long productId, @Valid @RequestBody UpdateCartRequest updateCartRequest) {
		return cartService.updateCart(userId, productId, updateCartRequest.getQuantity());
	}
}