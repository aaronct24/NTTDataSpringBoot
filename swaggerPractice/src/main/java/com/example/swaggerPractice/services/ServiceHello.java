package com.example.swaggerPractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.swaggerPractice.models.UserTest;
import com.example.swaggerPractice.repository.TestRepository;


@Service
public class ServiceHello {
	@Autowired
	private TestRepository tr;
	@Value("${course.message}")
	private String hello = "Hello World";
	
	public String muestraString() {
		return hello;
	}
	
	
	public List<UserTest> consultaTabla() {
		return tr.findAll();
	}
	
	public  UserTest borrarCampo(int id) {
		return tr.deleteById(id);
	}
	
	public UserTest agregarCampo(UserTest ut) {
		return tr.save(ut);
	}
	
	
	public UserTest update(UserTest ut) {
		return tr.save(ut);
	}
}
