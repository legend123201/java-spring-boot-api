package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.BillDetail;
import com.example.demo.restfulapi.model.compositeKey.BillDetailId;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailId> {
	List<BillDetail> findAllByBillDetailId_Bill(Bill bill); 
}