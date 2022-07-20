package com.example.demo.restfulapi.service.impl;

import java.util.List;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.restfulapi.dto.CartDto;
import com.example.demo.restfulapi.mapper.CartMapper;
import com.example.demo.restfulapi.message.ResponseMessage;
import com.example.demo.restfulapi.model.ResponseCustom;
import com.example.demo.restfulapi.model.User;
import com.example.demo.restfulapi.model.compositeKey.CartId;
import com.example.demo.restfulapi.model.request.CreateCartRequest;
import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.Product;
import com.example.demo.restfulapi.repository.CartRepository;
import com.example.demo.restfulapi.repository.ProductRepository;
import com.example.demo.restfulapi.repository.UserRepository;
import com.example.demo.restfulapi.service.ICartService;

@Service
public class CartService implements ICartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartMapper cartMapper;

	private ResponseMessage responseMessage = new ResponseMessage();

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(CartService.class);

	@Override
	public ResponseEntity<?> getCartsByUser(Long userId) {
		try {
			User user = userRepository.findById(userId).orElseThrow();
			List<Cart> cartsByUser = cartRepository.findAllByCartId_User(user);
			ResponseCustom<List<CartDto>> res = new ResponseCustom<List<CartDto>>(cartMapper.entityToDto(cartsByUser),
					responseMessage.GET_ALL_SUCCESS);
			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	public ResponseEntity<?> createCart(CreateCartRequest createCartRequest) {
		try {
			User user = userRepository.findById(createCartRequest.getUserId()).orElseThrow();
			Product product = productRepository.findById(createCartRequest.getProductId()).orElseThrow();

			CartId cartId = new CartId(user, product);
			Cart cart = new Cart(cartId, LocalDateTime.now(), createCartRequest.getQuantity());

			Cart newCart = cartRepository.save(cart);
			ResponseCustom<CartDto> res = new ResponseCustom<CartDto>(cartMapper.entityToDto(newCart),
					responseMessage.CREATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}

	@Override
	public ResponseEntity<?> deleteCart(Long userId, Long productId) {
		try {
			User user = userRepository.findById(userId).orElseThrow();
			Product product = productRepository.findById(productId).orElseThrow();

			CartId cartId = new CartId(user, product);
			Cart deleteCart = cartRepository.findById(cartId).orElseThrow();

			cartRepository.delete(deleteCart); // this function return void
			ResponseCustom<CartDto> res = new ResponseCustom<>(cartMapper.entityToDto(deleteCart),
					responseMessage.DELETE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	}

	@Override
	public ResponseEntity<?> updateCart(Long userId, Long productId, Long quantity) {
		try {
			User user = userRepository.findById(userId).orElseThrow();
			Product product = productRepository.findById(productId).orElseThrow();

			CartId cartId = new CartId(user, product);
			Cart updateCart = cartRepository.findById(cartId).orElseThrow();
			updateCart.setQuantity(quantity);

			Cart updatedCart = cartRepository.save(updateCart);
			ResponseCustom<CartDto> res = new ResponseCustom<>(cartMapper.entityToDto(updatedCart),
					responseMessage.UPDATE_SUCCESS);

			return ResponseEntity.ok().body(res);
		} catch (Exception e) {
			// TODO: handle exception
			ResponseCustom<String> res = new ResponseCustom<String>(null, e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}

	}
}
