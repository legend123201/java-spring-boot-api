package com.example.demo.restfulapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.restfulapi.model.compositeKey.BillDetailId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bill_detail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BillDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BillDetailId billDetailId;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "current_unit_sale_price")
	private Long currentUnitSalePrice;

	public BillDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetail(BillDetailId billDetailId, Long quantity, Long currentUnitSalePrice) {
		super();
		this.billDetailId = billDetailId;
		this.quantity = quantity;
		this.currentUnitSalePrice = currentUnitSalePrice;
	}

	public BillDetailId getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(BillDetailId billDetailId) {
		this.billDetailId = billDetailId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
