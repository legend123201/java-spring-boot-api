package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.ImportOrderDetailDto;
import com.example.demo.restfulapi.model.ImportOrderDetail;
import com.example.demo.restfulapi.model.compositeKey.ImportOrderDetailId;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImportOrderDetailMapper extends GenericMapper<ImportOrderDetail, ImportOrderDetailDto> {
	@Override
	public ImportOrderDetail dtoToEntity(ImportOrderDetailDto importOrderDetailDto) {
		ImportOrderDetailId importOrderDetailId = new ImportOrderDetailId(importOrderDetailDto.getImportOrder(),
				importOrderDetailDto.getProduct());
		return new ImportOrderDetail(importOrderDetailId, importOrderDetailDto.getQuantity(),
				importOrderDetailDto.getProduct().getUnitPerchasePrice());
	}

	@Override
	public ImportOrderDetailDto entityToDto(ImportOrderDetail importOrderDetail) {
		return new ImportOrderDetailDto(importOrderDetail.getQuantity(),
				importOrderDetail.getCurrentUnitPerchasePrice(),
				importOrderDetail.getImportOrderDetailId().getImportOrder(),
				importOrderDetail.getImportOrderDetailId().getProduct());
	}

	@Override
	public List<ImportOrderDetailDto> entityToDto(List<ImportOrderDetail> importOrderDetailList) {
		List<ImportOrderDetailDto> importOrderDetailDtoList = new ArrayList<>();

		for (ImportOrderDetail importOrderDetail : importOrderDetailList) {
			ImportOrderDetailDto importOrderDetailDto = entityToDto(importOrderDetail);
			importOrderDetailDtoList.add(importOrderDetailDto);
		}

		return importOrderDetailDtoList;
	}

	@Override
	public List<ImportOrderDetail> dtoToEntity(List<ImportOrderDetailDto> importOrderDetailDtoList) {
		List<ImportOrderDetail> importOrderDetailList = new ArrayList<>();

		for (ImportOrderDetailDto importOrderDetailDto : importOrderDetailDtoList) {
			ImportOrderDetail importOrderDetail = dtoToEntity(importOrderDetailDto);
			importOrderDetailList.add(importOrderDetail);
		}

		return importOrderDetailList;
	}
}
