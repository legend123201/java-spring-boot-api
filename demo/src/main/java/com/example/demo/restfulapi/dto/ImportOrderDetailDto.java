package com.example.demo.restfulapi.dto;

import com.example.demo.restfulapi.model.ImportOrder;
import com.example.demo.restfulapi.model.Product;

public class ImportOrderDetailDto {
	private Long quantity;
	private Long currentUnitPerchasePrice;
	private ImportOrder importOrder;
	private Product product;

	public ImportOrderDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportOrderDetailDto(Long quantity, Long currentUnitPerchasePrice, ImportOrder importOrder,
			Product product) {
		super();
		this.quantity = quantity;
		this.currentUnitPerchasePrice = currentUnitPerchasePrice;
		this.importOrder = importOrder;
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getCurrentUnitPerchasePrice() {
		return currentUnitPerchasePrice;
	}

	public void setCurrentUnitPerchasePrice(Long currentUnitPerchasePrice) {
		this.currentUnitPerchasePrice = currentUnitPerchasePrice;
	}

	public ImportOrder getImportOrder() {
		return importOrder;
	}

	public void setImportOrder(ImportOrder importOrder) {
		this.importOrder = importOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
