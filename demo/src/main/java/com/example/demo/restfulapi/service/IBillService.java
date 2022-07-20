package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

public interface IBillService {
	ResponseEntity<?> createBill(Long userId); 
}
