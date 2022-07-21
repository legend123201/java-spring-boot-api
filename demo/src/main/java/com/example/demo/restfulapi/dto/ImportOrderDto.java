package com.example.demo.restfulapi.dto;

import java.time.LocalDateTime;

import com.example.demo.restfulapi.model.Staff;

public class ImportOrderDto {
	private Long id;
	private LocalDateTime datetime;
	private Staff staff;

	public ImportOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportOrderDto(Long id, LocalDateTime datetime, Staff staff) {
		super();
		this.id = id;
		this.datetime = datetime;
		this.staff = staff;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
