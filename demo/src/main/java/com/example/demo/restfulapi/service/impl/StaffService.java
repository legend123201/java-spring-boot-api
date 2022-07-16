package com.example.demo.restfulapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.StaffDto;
import com.example.demo.restfulapi.mapper.StaffMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.repository.StaffRepository;
import com.example.demo.restfulapi.service.IStaffService;

@Service
public class StaffService implements IStaffService {
	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffMapper staffMapper;

	private ResponseMessage responseMessage = new ResponseMessage();
	
	// private static final Logger LOGGER = LoggerFactory.getLogger(StaffService.class);

	@Override
	public ResponseEntity<?> getAllStaffs() {
		try {
			List<Staff> allStaffs = staffRepository.findAll();
			ResponseCustom<List<StaffDto>> res = new ResponseCustom<List<StaffDto>>(staffMapper.entityToDto(allStaffs),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	public ResponseEntity<?> createStaff(StaffDto newStaffDto) {
		try {
			Staff newStaff = staffRepository.save(staffMapper.dtoToEntity(newStaffDto));
			ResponseCustom<StaffDto> res = new ResponseCustom<StaffDto>(staffMapper.entityToDto(newStaff),
					responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> deleteStaff(Long staffId) {
		try {
			Staff deleteStaff = staffRepository.findById(staffId).orElseThrow();
			staffRepository.delete(deleteStaff); // this function return void
			ResponseCustom<StaffDto> res = new ResponseCustom<>(staffMapper.entityToDto(deleteStaff),
					responseMessage.DELETE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> updateStaff(Long staffId, StaffDto updateStaffDto) {
		try {
			staffRepository.findById(staffId).orElseThrow();
			Staff updateStaff = staffRepository.save(staffMapper.dtoToEntity(updateStaffDto));
			ResponseCustom<StaffDto> res = new ResponseCustom<>(staffMapper.entityToDto(updateStaff),
					responseMessage.UPDATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}
}
