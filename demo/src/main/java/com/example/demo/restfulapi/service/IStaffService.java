package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.dto.StaffDto;

public interface IStaffService {
	ResponseEntity<?> getAllStaffs();
	ResponseEntity<?> createStaff(StaffDto newStaffDto); 
	ResponseEntity<?> deleteStaff(Long staffId); 
	ResponseEntity<?> updateStaff(Long staffId, StaffDto updateStaffDto); 
}
