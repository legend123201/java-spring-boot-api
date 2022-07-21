package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

public interface IBillService {
	ResponseEntity<?> getAllBills(); 
	ResponseEntity<?> getAllBillsByUserId(Long userId); 
	ResponseEntity<?> createBill(Long userId); 
	ResponseEntity<?> approveBill(Long staffId, Long billId); 
}
