package com.example.demo.restfulapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.BillDetailDto;
import com.example.demo.restfulapi.mapper.BillDetailMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.BillDetail;
import com.example.demo.restfulapi.repository.BillDetailRepository;
import com.example.demo.restfulapi.repository.BillRepository;
import com.example.demo.restfulapi.service.IBillDetailService;

@Service
public class BillDetailService implements IBillDetailService {
	@Autowired
	private BillDetailRepository billDetailRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private BillDetailMapper billDetailMapper;

	private ResponseMessage responseMessage = new ResponseMessage();

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(BillDetailService.class);

	@Override
	public ResponseEntity<?> getBillDetailsByBillId(Long billId) {
		try {
			Bill bill = billRepository.findById(billId).orElseThrow();
			List<BillDetail> billDetailsByBill = billDetailRepository.findAllByBillDetailId_Bill(bill);
			ResponseCustom<List<BillDetailDto>> res = new ResponseCustom<List<BillDetailDto>>(billDetailMapper.entityToDto(billDetailsByBill),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}	
}
