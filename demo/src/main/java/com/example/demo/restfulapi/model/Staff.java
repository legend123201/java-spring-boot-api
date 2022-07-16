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
@Table(name = "staff")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Staff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "gender")
	private Boolean gender;

	@Column(name = "address")
	private String address;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Bill> listBills;

	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ImportOrder> listImportOrders;

	public Staff() {
		super();
	}

	public Staff(Long id, String name, String phone, Boolean gender, String address, String username, String password,
			List<Bill> listBills, List<ImportOrder> listImportOrders) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.username = username;
		this.password = password;
		this.listBills = listBills;
		this.listImportOrders = listImportOrders;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Bill> getListBills() {
		return listBills;
	}

	public void setListBills(List<Bill> listBills) {
		this.listBills = listBills;
	}

	public List<ImportOrder> getListImportOrders() {
		return listImportOrders;
	}

	public void setListImportOrders(List<ImportOrder> listImportOrders) {
		this.listImportOrders = listImportOrders;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
