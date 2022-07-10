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
import com.example.demo.restfulapi.dto.UserDto;
import com.example.demo.restfulapi.service.IUserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto newUserDto) {
		return userService.createUser(newUserDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
		return userService.deleteUser(userId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody UserDto updateUserDto ) {
		return userService.updateUser(userId, updateUserDto);
	}
}