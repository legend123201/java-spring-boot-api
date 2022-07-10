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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
}
