package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.UserDto;
import com.example.demo.restfulapi.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class UserMapper extends GenericMapper<User, UserDto> {
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public User dtoToEntity(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

	@Override
	public UserDto entityToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> entityToDto(List<User> userList) {
		Type listType = new TypeToken<List<UserDto>>() {
		}.getType();

		return modelMapper.map(userList, listType);
	}

	@Override
	public List<User> dtoToEntity(List<UserDto> userDtoList) {
		Type listType = new TypeToken<List<User>>() {
		}.getType();

		return modelMapper.map(userDtoList, listType);
	}
}
