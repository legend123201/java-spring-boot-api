package com.example.demo.restfulapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.restfulapi.model.compositeKey.CartId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cart")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CartId cartId;

	@Column(name = "datetime")
	private LocalDateTime datetime;

	@Column(name = "quantity")
	private Long quantity;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(CartId cartId, LocalDateTime datetime, Long quantity) {
		super();
		this.cartId = cartId;
		this.datetime = datetime;
		this.quantity = quantity;
	}

	public CartId getCartId() {
		return cartId;
	}

	public void setCartId(CartId cartId) {
		this.cartId = cartId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
