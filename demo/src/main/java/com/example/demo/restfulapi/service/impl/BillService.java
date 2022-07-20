package com.example.demo.restfulapi.service.impl;

import java.util.List;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.BillDto;
import com.example.demo.restfulapi.mapper.BillMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.User;
import com.example.demo.restfulapi.model.compositeKey.BillDetailId;
import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.BillDetail;
import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.Product;
import com.example.demo.restfulapi.repository.BillDetailRepository;
import com.example.demo.restfulapi.repository.BillRepository;
import com.example.demo.restfulapi.repository.UserRepository;
import com.example.demo.restfulapi.repository.CartRepository;
import com.example.demo.restfulapi.repository.ProductRepository;
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
	private BillMapper billMapper;

	private ResponseMessage responseMessage = new ResponseMessage();

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(BillService.class);

	@Override
	public ResponseEntity<?> createBill(Long userId) {
		try {
			User user = userRepository.findById(userId).orElseThrow();
			List<Cart> cartList = cartRepository.findAllByCartId_User(user);

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
			
			ResponseCustom<BillDto> res = new ResponseCustom<BillDto>(billMapper.entityToDto(newBill),
					responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}
}
