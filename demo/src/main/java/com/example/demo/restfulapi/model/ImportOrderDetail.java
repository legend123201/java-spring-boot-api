package com.example.demo.restfulapi.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.example.demo.restfulapi.model.compositeKey.ImportOrderDetailId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "import_order_detail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ImportOrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ImportOrderDetailId importOrderDetailId;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "current_unit_perchase_price")
	private Long currentUnitPerchasePrice;

	public ImportOrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportOrderDetail(ImportOrderDetailId importOrderDetailId, Long quantity, Long currentUnitPerchasePrice) {
		super();
		this.importOrderDetailId = importOrderDetailId;
		this.quantity = quantity;
		this.currentUnitPerchasePrice = currentUnitPerchasePrice;
	}

	public ImportOrderDetailId getImportOrderDetailId() {
		return importOrderDetailId;
	}

	public void setImportOrderDetailId(ImportOrderDetailId importOrderDetailId) {
		this.importOrderDetailId = importOrderDetailId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
