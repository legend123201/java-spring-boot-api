package com.example.demo.restfulapi.model.request;

public class CreateCartRequest {
	private Long userId;
	private Long productId;
	private Long quantity;

	public CreateCartRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateCartRequest(Long userId, Long productId, Long quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
