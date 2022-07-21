package com.example.demo.restfulapi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.restfulapi.dto.BillDetailDto;
import com.example.demo.restfulapi.service.IBillDetailService;

@RestController
@RequestMapping("api/v1/billDetails")
public class BillDetailController {
	
	@Autowired
	private IBillDetailService billDetailService;

	@GetMapping("/billId/{billId}")
	public ResponseEntity<?> createBillDetail(@PathVariable(value = "billId") Long billId) {
		return billDetailService.getBillDetailsByBillId(billId);
	}
}