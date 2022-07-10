package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.dto.UserDto;

public interface IUserService {
	ResponseEntity<?> getAllUsers();
	ResponseEntity<?> createUser(UserDto newUserDto); 
	ResponseEntity<?> deleteUser(Long userId); 
	ResponseEntity<?> updateUser(Long userId, UserDto updateUserDto); 
}
