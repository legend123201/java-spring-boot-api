package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.BillDto;
import com.example.demo.restfulapi.model.Bill;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class BillMapper extends GenericMapper<Bill, BillDto> {
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Bill dtoToEntity(BillDto billDto) {
		return modelMapper.map(billDto, Bill.class);
	}

	@Override
	public BillDto entityToDto(Bill bill) {
		return modelMapper.map(bill, BillDto.class);
	}

	@Override
	public List<BillDto> entityToDto(List<Bill> billList) {
		Type listType = new TypeToken<List<BillDto>>() {
		}.getType();

		return modelMapper.map(billList, listType);
	}

	@Override
	public List<Bill> dtoToEntity(List<BillDto> billDtoList) {
		Type listType = new TypeToken<List<Bill>>() {
		}.getType();

		return modelMapper.map(billDtoList, listType);
	}
}
