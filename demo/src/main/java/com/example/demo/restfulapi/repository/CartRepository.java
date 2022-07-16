package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.User;
import com.example.demo.restfulapi.model.compositeKey.CartId;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
	List<Cart> findAllByCartId_User(User user);
}