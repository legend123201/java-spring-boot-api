package com.example.demo.restfulapi.model.compositeKey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.restfulapi.model.ImportOrder;
import com.example.demo.restfulapi.model.Product;

@Embeddable 
public class ImportOrderDetailId implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "import_order_id")
	private ImportOrder importOrder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	@Override
	public int hashCode() {
		return Objects.hash(importOrder, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportOrderDetailId other = (ImportOrderDetailId) obj;
		return Objects.equals(importOrder, other.importOrder) && Objects.equals(product, other.product);
	}

	public ImportOrderDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportOrderDetailId(ImportOrder importOrder, Product product) {
		super();
		this.importOrder = importOrder;
		this.product = product;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
 
} 