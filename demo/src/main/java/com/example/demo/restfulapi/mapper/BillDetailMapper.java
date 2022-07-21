package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.BillDetailDto;
import com.example.demo.restfulapi.model.BillDetail;
import com.example.demo.restfulapi.model.compositeKey.BillDetailId;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillDetailMapper extends GenericMapper<BillDetail, BillDetailDto> {
	@Override
	public BillDetail dtoToEntity(BillDetailDto billDetailDto) {
		BillDetailId billDetailId = new BillDetailId(billDetailDto.getBill(),
				billDetailDto.getProduct());
		return new BillDetail(billDetailId, billDetailDto.getQuantity(),
				billDetailDto.getProduct().getUnitSalePrice());
	}

	@Override
	public BillDetailDto entityToDto(BillDetail billDetail) {
		return new BillDetailDto(billDetail.getQuantity(),
				billDetail.getCurrentUnitSalePrice(),
				billDetail.getBillDetailId().getBill(),
				billDetail.getBillDetailId().getProduct());
	}

	@Override
	public List<BillDetailDto> entityToDto(List<BillDetail> billDetailList) {
		List<BillDetailDto> billDetailDtoList = new ArrayList<>();

		for (BillDetail billDetail : billDetailList) {
			BillDetailDto billDetailDto = entityToDto(billDetail);
			billDetailDtoList.add(billDetailDto);
		}

		return billDetailDtoList;
	}

	@Override
	public List<BillDetail> dtoToEntity(List<BillDetailDto> billDetailDtoList) {
		List<BillDetail> billDetailList = new ArrayList<>();

		for (BillDetailDto billDetailDto : billDetailDtoList) {
			BillDetail billDetail = dtoToEntity(billDetailDto);
			billDetailList.add(billDetail);
		}

		return billDetailList;
	}
}
