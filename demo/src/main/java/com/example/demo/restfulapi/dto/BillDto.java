package com.example.demo.restfulapi.dto;

import java.time.LocalDateTime;

import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.User;

public class BillDto {
	private Long id;
	private LocalDateTime datetime;
	private User user;
	private Staff staff;

	public BillDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDto(Long id, LocalDateTime datetime, User user, Staff staff) {
		super();
		this.id = id;
		this.datetime = datetime;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
