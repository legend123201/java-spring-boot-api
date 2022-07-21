package com.example.demo.restfulapi.model.request;

import java.util.List;

import com.example.demo.restfulapi.dto.ImportOrderDetailDto;

public class CreateImportOrderRequest {
	List<ImportOrderDetailDto> importOrderDetailDtoList;

	public CreateImportOrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateImportOrderRequest(List<ImportOrderDetailDto> importOrderDetailDtoList) {
		super();
		this.importOrderDetailDtoList = importOrderDetailDtoList;
	}

	public List<ImportOrderDetailDto> getImportOrderDetailDtoList() {
		return importOrderDetailDtoList;
	}

	public void setImportOrderDetailDtoList(List<ImportOrderDetailDto> importOrderDetailDtoList) {
		this.importOrderDetailDtoList = importOrderDetailDtoList;
	}

}
