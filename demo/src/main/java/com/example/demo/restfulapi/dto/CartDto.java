package com.example.demo.restfulapi.dto;

import java.time.LocalDateTime;

import com.example.demo.restfulapi.model.Product;
import com.example.demo.restfulapi.model.User;

public class CartDto {
	private User user;
	private Product product;
	private LocalDateTime datetime;
	private Long quantity;

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDto(User user, Product product, LocalDateTime datetime, Long quantity) {
		super();
		this.user = user;
		this.product = product;
		this.datetime = datetime;
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
