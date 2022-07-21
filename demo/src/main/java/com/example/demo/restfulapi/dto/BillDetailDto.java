package com.example.demo.restfulapi.dto;

import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.Product;

public class BillDetailDto {
	private Long quantity;
	private Long currentUnitSalePrice;
	private Bill bill;
	private Product product;

	public BillDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetailDto(Long quantity, Long currentUnitSalePrice, Bill bill, Product product) {
		super();
		this.quantity = quantity;
		this.currentUnitSalePrice = currentUnitSalePrice;
		this.bill = bill;
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getCurrentUnitSalePrice() {
		return currentUnitSalePrice;
	}

	public void setCurrentUnitSalePrice(Long currentUnitSalePrice) {
		this.currentUnitSalePrice = currentUnitSalePrice;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
