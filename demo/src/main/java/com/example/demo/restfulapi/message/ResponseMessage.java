package com.example.demo.restfulapi.message;

public class ResponseMessage {
	// SUCCESS
	public String GET_ALL_SUCCESS = "Get all success!";
	public String GET_ITEM_SUCCESS = "Get item success!";
	public String CREATE_SUCCESS = "Create success!";
	public String DELETE_SUCCESS = "Delete success!";
	public String UPDATE_SUCCESS = "Update success!";
	
	public String LOGIN_SUCCESS = "Login success!";
	public String ANALYTIC_SUCCESS = "Analytic success!";
	
	// FAILED
	public String LOGIN_FAILED = "Login failed, please recheck username and password!";
	
	public String NOT_ENOUGH_QUANTITY = "Not enough quantity in stock!";
	public String NO_ITEM_IN_CART = "User have no item in cart!";
	public String NO_ITEM_IN_IMPORT_ORDER = "Import order have no items!";
}
