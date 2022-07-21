package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.model.request.CreateImportOrderRequest;

public interface IImportOrderService {
	ResponseEntity<?> getAllImportOrders(); 
	ResponseEntity<?> createImportOrder(Long staffId, CreateImportOrderRequest createImportOrderRequest); 
}
