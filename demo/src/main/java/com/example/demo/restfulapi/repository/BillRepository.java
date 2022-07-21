package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.User;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	List<Bill> findAllByUser(User user); 
	
	@Query(value = "SELECT COUNT(*) as totalBill FROM bill WHERE staff_id IS NOT NULL", nativeQuery = true)
    int totalCompletedBill();
}