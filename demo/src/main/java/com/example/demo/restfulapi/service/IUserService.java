package com.example.demo.restfulapi.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.restfulapi.dto.UserDto;

public interface IUserService {
	ResponseEntity<?> login(String username, String password);
	ResponseEntity<?> getAllUsers();
	ResponseEntity<?> getUserById(Long userId);
	ResponseEntity<?> createUser(UserDto newUserDto); 
	ResponseEntity<?> deleteUser(Long userId); 
	ResponseEntity<?> updateUser(Long userId, UserDto updateUserDto); 
}
