package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.StaffDto;
import com.example.demo.restfulapi.model.Staff;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class StaffMapper extends GenericMapper<Staff, StaffDto> {
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Staff dtoToEntity(StaffDto staffDto) {
		return modelMapper.map(staffDto, Staff.class);
	}

	@Override
	public StaffDto entityToDto(Staff staff) {
		return modelMapper.map(staff, StaffDto.class);
	}

	@Override
	public List<StaffDto> entityToDto(List<Staff> staffList) {
		Type listType = new TypeToken<List<StaffDto>>() {
		}.getType();

		return modelMapper.map(staffList, listType);
	}

	@Override
	public List<Staff> dtoToEntity(List<StaffDto> staffDtoList) {
		Type listType = new TypeToken<List<Staff>>() {
		}.getType();

		return modelMapper.map(staffDtoList, listType);
	}
}
