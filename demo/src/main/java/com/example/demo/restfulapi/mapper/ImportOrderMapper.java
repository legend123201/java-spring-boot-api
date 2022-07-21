package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.ImportOrderDto;
import com.example.demo.restfulapi.model.ImportOrder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ImportOrderMapper extends GenericMapper<ImportOrder, ImportOrderDto> {
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public ImportOrder dtoToEntity(ImportOrderDto importOrderDto) {
		return modelMapper.map(importOrderDto, ImportOrder.class);
	}

	@Override
	public ImportOrderDto entityToDto(ImportOrder importOrder) {
		return modelMapper.map(importOrder, ImportOrderDto.class);
	}

	@Override
	public List<ImportOrderDto> entityToDto(List<ImportOrder> importOrderList) {
		Type listType = new TypeToken<List<ImportOrderDto>>() {
		}.getType();

		return modelMapper.map(importOrderList, listType);
	}

	@Override
	public List<ImportOrder> dtoToEntity(List<ImportOrderDto> importOrderDtoList) {
		Type listType = new TypeToken<List<ImportOrder>>() {
		}.getType();

		return modelMapper.map(importOrderDtoList, listType);
	}
}
