package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.ImportOrder;
import com.example.demo.restfulapi.model.ImportOrderDetail;
import com.example.demo.restfulapi.model.compositeKey.ImportOrderDetailId;

@Repository
public interface ImportOrderDetailRepository extends JpaRepository<ImportOrderDetail, ImportOrderDetailId> {
	List<ImportOrderDetail> findAllByImportOrderDetailId_ImportOrder(ImportOrder importOrder); 
}