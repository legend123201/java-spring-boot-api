package com.example.demo.restfulapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.StaffDto;
import com.example.demo.restfulapi.dto.UserDto;
import com.example.demo.restfulapi.mapper.UserMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.User;
import com.example.demo.restfulapi.repository.UserRepository;
import com.example.demo.restfulapi.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	private ResponseMessage responseMessage = new ResponseMessage();
	
	// private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Override
	public ResponseEntity<?> login(String username, String password) {
		try {
			List<User> userList = userRepository.login(username, password);
			if(userList.size() == 1) {
				ResponseCustom<List<UserDto>> res = new ResponseCustom<List<UserDto>>(userMapper.entityToDto(userList),
						responseMessage.LOGIN_SUCCESS);
				return ResponseEntity.ok().body(res);
			}else {
				ResponseCustom<String> res = new ResponseCustom<String>(null, responseMessage.LOGIN_FAILED);
				return ResponseEntity.badRequest().body(res);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
	@Override
	public ResponseEntity<?> getAllUsers() {
		try {
			List<User> allUsers = userRepository.findAll();
			ResponseCustom<List<UserDto>> res = new ResponseCustom<List<UserDto>>(userMapper.entityToDto(allUsers),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	public ResponseEntity<?> getUserById(Long userId) {
		try {
			User user = userRepository.findById(userId).orElseThrow();
			ResponseCustom<UserDto> res = new ResponseCustom<UserDto>(userMapper.entityToDto(user),
					responseMessage.GET_ITEM_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
	
	@Override
	public ResponseEntity<?> createUser(UserDto newUserDto) {
		try {
			User newUser = userRepository.save(userMapper.dtoToEntity(newUserDto));
			ResponseCustom<UserDto> res = new ResponseCustom<UserDto>(userMapper.entityToDto(newUser),
					responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> deleteUser(Long userId) {
		try {
			User deleteUser = userRepository.findById(userId).orElseThrow();
			userRepository.delete(deleteUser); // this function return void
			ResponseCustom<UserDto> res = new ResponseCustom<>(userMapper.entityToDto(deleteUser),
					responseMessage.DELETE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> updateUser(Long userId, UserDto updateUserDto) {
		try {
			userRepository.findById(userId).orElseThrow();
			User updateUser = userRepository.save(userMapper.dtoToEntity(updateUserDto));
			ResponseCustom<UserDto> res = new ResponseCustom<>(userMapper.entityToDto(updateUser),
					responseMessage.UPDATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}
}
