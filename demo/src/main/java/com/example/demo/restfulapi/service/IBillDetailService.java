package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

public interface IBillDetailService {
	ResponseEntity<?> getBillDetailsByBillId(Long billId);
}
