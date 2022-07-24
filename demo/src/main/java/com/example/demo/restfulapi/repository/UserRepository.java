package com.example.demo.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.restfulapi.model.Staff;
import com.example.demo.restfulapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT COUNT(*) as totalUser FROM user", nativeQuery = true)
    int totalUser();
	
	@Query(value = "SELECT * FROM user WHERE username = :username AND password = :password", nativeQuery = true)
	List<User> login(@Param("username") String username, @Param("password") String password);
}