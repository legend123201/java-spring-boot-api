package com.example.demo.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.ImportOrder;

@Repository
public interface ImportOrderRepository extends JpaRepository<ImportOrder, Long> {

}