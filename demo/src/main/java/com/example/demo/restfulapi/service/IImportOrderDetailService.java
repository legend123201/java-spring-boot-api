package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

public interface IImportOrderDetailService {
	ResponseEntity<?> getImportOrderDetailsByImportOrderId(Long importOrderId);
}
