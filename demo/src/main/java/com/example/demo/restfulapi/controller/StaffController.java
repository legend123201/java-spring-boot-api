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
import com.example.demo.restfulapi.dto.StaffDto;
import com.example.demo.restfulapi.service.IStaffService;

@RestController
@RequestMapping("api/v1/staffs")
public class StaffController {
	
	@Autowired
	private IStaffService staffService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllStaffs() {
		return staffService.getAllStaffs();
	}

	@PostMapping("")
	public ResponseEntity<?> createStaff(@Valid @RequestBody StaffDto newStaffDto) {
		return staffService.createStaff(newStaffDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStaff(@PathVariable(value = "id") Long staffId) {
		return staffService.deleteStaff(staffId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStaff(@PathVariable(value = "id") Long staffId, @Valid @RequestBody StaffDto updateStaffDto ) {
		return staffService.updateStaff(staffId, updateStaffDto);
	}
}