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
import com.example.demo.restfulapi.service.IBillService;

@RestController
@RequestMapping("api/v1/bills")
@CrossOrigin
public class BillController {
	
	@Autowired
	private IBillService billService;

	@GetMapping("")
	public ResponseEntity<?> getAllBills() {
		return billService.getAllBills();
	}
	
	@GetMapping("/userId/{userId}")
	public ResponseEntity<?> getAllBillsByUserId(@PathVariable(value = "userId") Long userId) {
		return billService.getAllBillsByUserId(userId);
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> getBillsForReport() {
		return billService.getBillsForReport();
	}
	
	@PostMapping("/userId/{userId}")
	public ResponseEntity<?> createBill(@PathVariable(value = "userId") Long userId) {
		return billService.createBill(userId);
	}
	
	@PutMapping("/staffId/{staffId}/billId/{billId}")
	public ResponseEntity<?> approveBill(@PathVariable(value = "staffId") Long staffId, @PathVariable(value = "billId") Long billId) {
		return billService.approveBill(staffId, billId);
	}
}