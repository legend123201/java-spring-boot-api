package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Bill;
import com.example.demo.restfulapi.model.Cart;
import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.User;
import com.example.demo.restfulapi.model.extra.BillAndPrice;
import com.example.demo.restfulapi.model.extra.UserBills;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	List<Bill> findAllByUser(User user);

	@Query(value = "SELECT COUNT(*) as totalBill FROM bill WHERE staff_id IS NOT NULL", nativeQuery = true)
	int totalCompletedBill();

	@Query(value = "SELECT bill_id AS billId, datetime, SUM( quantity * current_unit_sale_price ) AS billPrice FROM bill, bill_detail WHERE bill.id = bill_detail.bill_id AND staff_id IS NOT NULL GROUP BY bill.id", nativeQuery = true)
	List<BillAndPrice> BillAndPriceList();

	@Query(value = "SELECT bill_id as billId, datetime, staff_id as staffId, SUM(current_unit_sale_price * quantity) AS total, IF(staff_id IS NULL, 0, 1) AS isApproved\r\n"
			+ "FROM bill, bill_detail\r\n" + "WHERE bill.id = bill_detail.bill_id AND bill.user_id = :userId\r\n"
			+ "GROUP BY bill_id\r\n" + "ORDER BY DATETIME\r\n" + "DESC", nativeQuery = true)
	List<UserBills> BillListByUserId(@Param("userId") Long userId);
}