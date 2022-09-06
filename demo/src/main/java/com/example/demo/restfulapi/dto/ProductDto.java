package com.example.demo.restfulapi.dto;

import com.example.demo.restfulapi.model.Category;

public class ProductDto {
	private Long id;
	private String name;
	private Long quantityInStock;
	private Long unitPerchasePrice;
	private Long unitSalePrice;
	private String measureUnit;
	private String image;
	private Category category;

	public ProductDto() {
		super();
	}

	public ProductDto(Long id, String name, Long quantityInStock, Long unitPerchasePrice, Long unitSalePrice,
			String measureUnit, String image, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.unitPerchasePrice = unitPerchasePrice;
		this.unitSalePrice = unitSalePrice;
		this.measureUnit = measureUnit;
		this.image = image;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
