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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
}
