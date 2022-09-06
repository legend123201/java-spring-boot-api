package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;


public interface IAnalyticService {
	ResponseEntity<?> analyticUser();
	ResponseEntity<?> analyticBill();
	ResponseEntity<?> analyticRevenueByMonth(Integer analyticYear);
	ResponseEntity<?> analyticProfitByMonth(Integer analyticYear);
}
