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
import com.example.demo.restfulapi.repository.BillRepository;
import com.example.demo.restfulapi.repository.ImportOrderDetailRepository;
import com.example.demo.restfulapi.repository.ImportOrderRepository;
import com.example.demo.restfulapi.repository.UserRepository;
import com.example.demo.restfulapi.service.IAnalyticService;
import com.example.demo.restfulapi.service.IImportOrderDetailService;

@Service
public class AnalyticService implements IAnalyticService {


	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BillRepository billRepository;

	@Autowired
	private ImportOrderDetailMapper importOrderDetailMapper;

	private ResponseMessage responseMessage = new ResponseMessage();

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(ImportOrderDetailService.class);

	@Override
	public ResponseEntity<?> analyticUser() {
		try {
			Integer totalUser = userRepository.totalUser();
			ResponseCustom<Integer> res = new ResponseCustom<Integer>(totalUser,
					responseMessage.ANALYTIC_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}	
	
	@Override
	public ResponseEntity<?> analyticBill() {
		try {
			Integer totalCompleted = billRepository.totalCompletedBill();
			ResponseCustom<Integer> res = new ResponseCustom<Integer>(totalCompleted,
					responseMessage.ANALYTIC_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}	
}
