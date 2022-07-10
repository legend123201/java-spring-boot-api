package com.example.demo.restfulapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity_in_stock")
	private Long quantityInStock;

	@Column(name = "unit_perchase_price")
	private Long unitPerchasePrice;
	
	@Column(name = "unit_sale_price")
	private Long unitSalePrice;
	
	@Column(name = "measure_unit")
	private String measureUnit;
	
	@Column(name = "image")
	private String image;
	
	@OneToMany(mappedBy = "cartId.product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Cart> listCarts;
	
	@OneToMany(mappedBy = "billDetailId.product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BillDetail> listBillDetails;
	
	@OneToMany(mappedBy = "importOrderDetailId.product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ImportOrderDetail> listImportOrderDetails;
}
