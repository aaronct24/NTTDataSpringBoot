package com.example.swaggerPractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swaggerPractice.models.UserTest;

@Repository
public interface TestRepository extends JpaRepository<UserTest, Integer>{
	
	List <UserTest>findAll();
	UserTest deleteById(int id);
	UserTest save(UserTest ut);
	
}
