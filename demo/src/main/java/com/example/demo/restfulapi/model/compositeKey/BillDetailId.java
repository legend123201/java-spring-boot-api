package com.example.demo.restfulapi.model.compositeKey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.Product;

@Embeddable
public class BillDetailId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id")
	private Bill bill;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	@Override
	public int hashCode() {
		return Objects.hash(bill, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillDetailId other = (BillDetailId) obj;
		return Objects.equals(bill, other.bill) && Objects.equals(product, other.product);
	}

	public BillDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetailId(Bill bill, Product product) {
		super();
		this.bill = bill;
		this.product = product;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
