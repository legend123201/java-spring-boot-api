package com.example.demo.restfulapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.ImportOrderDetailDto;
import com.example.demo.restfulapi.mapper.ImportOrderDetailMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.ImportOrder;
import com.example.demo.restfulapi.model.ImportOrderDetail;
import com.example.demo.restfulapi.repository.ImportOrderDetailRepository;
import com.example.demo.restfulapi.repository.ImportOrderRepository;
import com.example.demo.restfulapi.service.IImportOrderDetailService;

@Service
public class ImportOrderDetailService implements IImportOrderDetailService {
	@Autowired
	private ImportOrderDetailRepository importOrderDetailRepository;

	@Autowired
	private ImportOrderRepository importOrderRepository;

	@Autowired
	private ImportOrderDetailMapper importOrderDetailMapper;

	private ResponseMessage responseMessage = new ResponseMessage();

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(ImportOrderDetailService.class);

	@Override
	public ResponseEntity<?> getImportOrderDetailsByImportOrderId(Long importOrderId) {
		try {
			ImportOrder importOrder = importOrderRepository.findById(importOrderId).orElseThrow();
			List<ImportOrderDetail> importOrderDetailsByImportOrder = importOrderDetailRepository.findAllByImportOrderDetailId_ImportOrder(importOrder);
			ResponseCustom<List<ImportOrderDetailDto>> res = new ResponseCustom<List<ImportOrderDetailDto>>(importOrderDetailMapper.entityToDto(importOrderDetailsByImportOrder),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}	
}
