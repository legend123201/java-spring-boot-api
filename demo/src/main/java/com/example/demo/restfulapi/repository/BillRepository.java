package com.example.demo.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}