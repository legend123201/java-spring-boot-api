package com.example.demo.restfulapi.model.request;

public class UpdateCartRequest {
	private Long quantity;

	public UpdateCartRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateCartRequest(Long quantity) {
		super();
		this.quantity = quantity;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
