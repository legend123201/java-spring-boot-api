package com.example.demo.restfulapi.service.impl;

import java.util.List;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.restfulapi.dto.BillDetailDto;
import com.example.demo.restfulapi.dto.BillDto;
import com.example.demo.restfulapi.dto.ImportOrderDto;
import com.example.demo.restfulapi.mapper.BillMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.User;
import com.example.demo.restfulapi.model.compositeKey.BillDetailId;
import com.example.demo.restfulapi.model.extra.BillAndPrice;
import com.example.demo.restfulapi.model.extra.UserBills;
import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.BillDetail;
import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.ImportOrder;
import com.example.demo.restfulapi.model.Product;
import com.example.demo.restfulapi.repository.BillDetailRepository;
import com.example.demo.restfulapi.repository.BillRepository;
import com.example.demo.restfulapi.repository.UserRepository;
import com.example.demo.restfulapi.repository.CartRepository;
import com.example.demo.restfulapi.repository.ProductRepository;
import com.example.demo.restfulapi.repository.StaffRepository;
import com.example.demo.restfulapi.service.IBillService;

@Service
public class BillService implements IBillService {
	@Autowired
	private BillRepository billRepository;

	@Autowired
	private BillDetailRepository billDetailRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private BillMapper billMapper;

	private ResponseMessage responseMessage = new ResponseMessage();

	private static final Logger LOGGER = LoggerFactory.getLogger(BillService.class);

	@Override
	public ResponseEntity<?> getAllBills() {
		try {
			List<Bill> allBills = billRepository.findAll();
			ResponseCustom<List<BillDto>> res = new ResponseCustom<List<BillDto>>(billMapper.entityToDto(allBills),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	public ResponseEntity<?> getAllBillsByUserId(Long userId) {
		try {
			User user = userRepository.findById(userId).orElseThrow();
			List<UserBills> billList = billRepository.BillListByUserId(userId);
			
			ResponseCustom<List<UserBills>> res = new ResponseCustom<List<UserBills>>(billList,
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
	public ResponseEntity<?> createBill(Long userId) {
		try {
			User user = userRepository.findById(userId).orElseThrow();
			List<Cart> cartList = cartRepository.findAllByCartId_User(user);

			if (cartList.isEmpty()) {
				ResponseCustom<String> res = new ResponseCustom<String>(null, responseMessage.NO_ITEM_IN_CART);
				return ResponseEntity.badRequest().body(res);
			}

			// ktra so luong ton
			for (Cart cart : cartList) {
				Product product = productRepository.findById(cart.getCartId().getProduct().getId()).orElseThrow();

				if (product.getQuantityInStock() < cart.getQuantity()) {
					ResponseCustom<String> res = new ResponseCustom<String>(null, responseMessage.NOT_ENOUGH_QUANTITY);
					return ResponseEntity.badRequest().body(res);
				}
			}

			// them bill
			Bill bill = new Bill(LocalDateTime.now(), user, null);
			Bill newBill = billRepository.save(bill);

			// them bill detail
			for (Cart cart : cartList) {
				Product product = productRepository.findById(cart.getCartId().getProduct().getId()).orElseThrow();

				BillDetailId billDetailId = new BillDetailId(newBill, product);
				BillDetail billDetail = new BillDetail(billDetailId, cart.getQuantity(), product.getUnitSalePrice());
				billDetailRepository.save(billDetail);
			}

			// xoa cart
			cartRepository.deleteAllByCartId_User(user);

			ResponseCustom<BillDto> res = new ResponseCustom<BillDto>(billMapper.entityToDto(newBill),
					responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	public ResponseEntity<?> approveBill(Long staffId, Long billId) {
		try {
			Staff staff = staffRepository.findById(staffId).orElseThrow();
			Bill bill = billRepository.findById(billId).orElseThrow();

			// update bill
			bill.setStaff(staff);

			Bill updatedBill = billRepository.save(bill);

			ResponseCustom<BillDto> res = new ResponseCustom<BillDto>(billMapper.entityToDto(updatedBill),
					responseMessage.UPDATE_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}
}
