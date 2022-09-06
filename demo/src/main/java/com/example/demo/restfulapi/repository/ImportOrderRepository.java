package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.ImportOrder;
import com.example.demo.restfulapi.model.extra.BillAndPrice;
import com.example.demo.restfulapi.model.extra.ImportOrderAndPrice;
import com.example.demo.restfulapi.model.extra.ImportOrderForReport;

@Repository
public interface ImportOrderRepository extends JpaRepository<ImportOrder, Long> {
	
	@Query(value = "SELECT import_order_id AS importOrderId, datetime, SUM( quantity * current_unit_perchase_price ) AS importOrderPrice FROM import_order, import_order_detail WHERE import_order.id = import_order_detail.import_order_id GROUP BY import_order.id;", nativeQuery = true)
	List<ImportOrderAndPrice> ImportOrderAndPriceList();
	
	@Query(value = "SELECT import_order_id AS importOrderId, datetime, SUM( quantity * current_unit_perchase_price ) AS importOrderPrice, staff.name as staffName\r\n"
			+ "FROM import_order, import_order_detail, staff \r\n"
			+ "WHERE import_order.id = import_order_detail.import_order_id AND import_order.staff_id = staff.id\r\n"
			+ "GROUP BY import_order.id;", nativeQuery = true)
	List<ImportOrderForReport> ImportOrderForReportList();
}