package com.example.demo.restfulapi.service.impl;

import java.util.List;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.restfulapi.dto.ImportOrderDetailDto;
import com.example.demo.restfulapi.dto.ImportOrderDto;
import com.example.demo.restfulapi.dto.UserDto;
import com.example.demo.restfulapi.mapper.ImportOrderMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.User;
import com.example.demo.restfulapi.model.compositeKey.ImportOrderDetailId;
import com.example.demo.restfulapi.model.extra.ImportOrderForReport;
import com.example.demo.restfulapi.model.request.CreateImportOrderRequest;
import com.example.demo.restfulapi.model.ImportOrder;
import com.example.demo.restfulapi.model.ImportOrderDetail;
import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.Product;
import com.example.demo.restfulapi.repository.ImportOrderDetailRepository;
import com.example.demo.restfulapi.repository.ImportOrderRepository;
import com.example.demo.restfulapi.repository.StaffRepository;
import com.example.demo.restfulapi.repository.CartRepository;
import com.example.demo.restfulapi.repository.ProductRepository;
import com.example.demo.restfulapi.service.IImportOrderService;

@Service
public class ImportOrderService implements IImportOrderService {
	@Autowired
	private ImportOrderRepository importOrderRepository;

	@Autowired
	private ImportOrderDetailRepository importOrderDetailRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ImportOrderMapper importOrderMapper;

	private ResponseMessage responseMessage = new ResponseMessage();

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(ImportOrderService.class);
	
	@Override
	public ResponseEntity<?> getAllImportOrders() {
		try {
			List<ImportOrder> allImportOrders = importOrderRepository.findAll();
			ResponseCustom<List<ImportOrderDto>> res = new ResponseCustom<List<ImportOrderDto>>(importOrderMapper.entityToDto(allImportOrders),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
	
	@Override
	public ResponseEntity<?> getImportOrdersForReport() {
		try {
			List<ImportOrderForReport> importOrderForReportList = importOrderRepository.ImportOrderForReportList();
			ResponseCustom<List<ImportOrderForReport>> res = new ResponseCustom<List<ImportOrderForReport>>(importOrderForReportList,
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	@Transactional
	public ResponseEntity<?> createImportOrder(Long staffId, CreateImportOrderRequest createImportOrderRequest) {
		try {
			Staff staff = staffRepository.findById(staffId).orElseThrow();
			List<ImportOrderDetailDto> importOrderDetailDtoList = createImportOrderRequest
					.getImportOrderDetailDtoList();

			if (importOrderDetailDtoList.isEmpty()) {
				ResponseCustom<String> res = new ResponseCustom<String>(null, responseMessage.NO_ITEM_IN_IMPORT_ORDER);
				return ResponseEntity.badRequest().body(res);
			}

			// them importOrder
			ImportOrder importOrder = new ImportOrder(LocalDateTime.now(), staff);
			ImportOrder newImportOrder = importOrderRepository.save(importOrder);

			// them importOrder detail
			for (ImportOrderDetailDto importOrderDetailDto : importOrderDetailDtoList) {
				Product product = productRepository.findById(importOrderDetailDto.getProduct().getId()).orElseThrow();
				importOrderDetailDto.setImportOrder(newImportOrder);

				ImportOrderDetailId importOrderDetailId = new ImportOrderDetailId(newImportOrder, product);
				ImportOrderDetail importOrderDetail = new ImportOrderDetail(importOrderDetailId,
						importOrderDetailDto.getQuantity(), importOrderDetailDto.getCurrentUnitPerchasePrice());
				importOrderDetailRepository.save(importOrderDetail);
			}

			ResponseCustom<ImportOrderDto> res = new ResponseCustom<ImportOrderDto>(
					importOrderMapper.entityToDto(newImportOrder), responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}
}
