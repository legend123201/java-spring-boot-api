package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.dto.StaffDto;

public interface IStaffService {
	ResponseEntity<?> login(String username, String password);
	ResponseEntity<?> getAllStaffs();
	ResponseEntity<?> getStaffById(Long staffId);
	ResponseEntity<?> createStaff(StaffDto newStaffDto); 
	ResponseEntity<?> deleteStaff(Long staffId); 
	ResponseEntity<?> updateStaff(Long staffId, StaffDto updateStaffDto); 
}
