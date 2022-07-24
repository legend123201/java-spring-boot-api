package com.example.demo.restfulapi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.restfulapi.dto.BillDto;
import com.example.demo.restfulapi.service.IAnalyticService;
import com.example.demo.restfulapi.service.IBillService;

@RestController
@RequestMapping("api/v1/analytics")
@CrossOrigin
public class AnalyticController {
	
	@Autowired
	private IAnalyticService analyticService;

	@GetMapping("/user")
	public ResponseEntity<?> analyticUser() {
		return analyticService.analyticUser();
	}
	
	@GetMapping("/bill")
	public ResponseEntity<?> analyticBill() {
		return analyticService.analyticBill();
	}
	
	@GetMapping("/revenue")
	public ResponseEntity<?> analyticRevenueByMonth() {
		return analyticService.analyticRevenueByMonth();
	}
}