package com.example.demo.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}