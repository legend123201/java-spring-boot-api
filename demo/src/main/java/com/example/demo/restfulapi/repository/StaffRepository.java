package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	@Query(value = "SELECT * FROM staff WHERE username = :username AND password = :password", nativeQuery = true)
	List<Staff> login(@Param("username") String username, @Param("password") String password);
}