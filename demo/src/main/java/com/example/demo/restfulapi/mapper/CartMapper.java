package com.example.demo.restfulapi.mapper;

import com.example.demo.restfulapi.dto.CartDto;
import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.compositeKey.CartId;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartMapper extends GenericMapper<Cart, CartDto> {
	@Override
	public Cart dtoToEntity(CartDto cartDto) {
		CartId cartId = new CartId(cartDto.getUser(), cartDto.getProduct());
		return new Cart(cartId, cartDto.getDatetime(), cartDto.getQuantity());
	}

	@Override
	public CartDto entityToDto(Cart cart) {
		return new CartDto(cart.getCartId().getUser(), cart.getCartId().getProduct(), cart.getDatetime(),
				cart.getQuantity());
	}

	@Override
	public List<CartDto> entityToDto(List<Cart> cartList) {
		List<CartDto> cartDtoList = new ArrayList<>();

		for (Cart cart : cartList) {
			CartDto cartDto = entityToDto(cart);
			cartDtoList.add(cartDto);
		}

		return cartDtoList;
	}

	@Override
	public List<Cart> dtoToEntity(List<CartDto> cartDtoList) {
		List<Cart> cartList = new ArrayList<>();

		for (CartDto cartDto : cartDtoList) {
			Cart cart = dtoToEntity(cartDto);
			cartList.add(cart);
		}

		return cartList;
	}
}
