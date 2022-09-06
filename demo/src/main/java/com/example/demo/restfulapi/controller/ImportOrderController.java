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
import com.example.demo.restfulapi.dto.ImportOrderDto;
import com.example.demo.restfulapi.dto.UserDto;
import com.example.demo.restfulapi.model.request.CreateImportOrderRequest;
import com.example.demo.restfulapi.service.IImportOrderService;

@RestController
@RequestMapping("api/v1/importOrders")
@CrossOrigin
public class ImportOrderController {

	@Autowired
	private IImportOrderService importOrderService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllImportOrders() {
		return importOrderService.getAllImportOrders();
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> getImportOrdersForReport() {
		return importOrderService.getImportOrdersForReport();
	}

	@PostMapping("/staffId/{staffId}")
	public ResponseEntity<?> createImportOrder(@PathVariable(value = "staffId") Long staffId,
			@Valid @RequestBody CreateImportOrderRequest createImportOrderRequest) {
		return importOrderService.createImportOrder(staffId, createImportOrderRequest);
	}
}