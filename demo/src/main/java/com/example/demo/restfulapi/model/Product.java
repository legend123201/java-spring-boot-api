package com.example.demo.restfulapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	public Product() {
		super();
	}

	public Product(Long id, String name, Long quantityInStock, Long unitPerchasePrice, Long unitSalePrice,
			String measureUnit, String image, List<Cart> listCarts, List<BillDetail> listBillDetails,
			List<ImportOrderDetail> listImportOrderDetails, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.unitPerchasePrice = unitPerchasePrice;
		this.unitSalePrice = unitSalePrice;
		this.measureUnit = measureUnit;
		this.image = image;
		this.listCarts = listCarts;
		this.listBillDetails = listBillDetails;
		this.listImportOrderDetails = listImportOrderDetails;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Long quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Long getUnitPerchasePrice() {
		return unitPerchasePrice;
	}

	public void setUnitPerchasePrice(Long unitPerchasePrice) {
		this.unitPerchasePrice = unitPerchasePrice;
	}

	public Long getUnitSalePrice() {
		return unitSalePrice;
	}

	public void setUnitSalePrice(Long unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Cart> getListCarts() {
		return listCarts;
	}

	public void setListCarts(List<Cart> listCarts) {
		this.listCarts = listCarts;
	}

	public List<BillDetail> getListBillDetails() {
		return listBillDetails;
	}

	public void setListBillDetails(List<BillDetail> listBillDetails) {
		this.listBillDetails = listBillDetails;
	}

	public List<ImportOrderDetail> getListImportOrderDetails() {
		return listImportOrderDetails;
	}

	public void setListImportOrderDetails(List<ImportOrderDetail> listImportOrderDetails) {
		this.listImportOrderDetails = listImportOrderDetails;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
