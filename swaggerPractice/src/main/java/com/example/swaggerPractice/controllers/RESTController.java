package com.example.swaggerPractice.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.swaggerPractice.models.UserTest;
import com.example.swaggerPractice.services.ServiceHello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "miApi")
@RestController
@Validated
public class RESTController {
	
	@Autowired
	private ServiceHello serviceHello;
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	return new ResponseEntity<>("Error el la validación " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	@ResponseBody	
	public String muestraString() {
		return serviceHello.muestraString();
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/users")
	@ResponseBody
	public List<UserTest> getUser() {
		return serviceHello.consultaTabla();
	}
	
	@ApiOperation(value = "Delete a role binding")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Success"),
	        @ApiResponse(code = 404, message = "Server not found"),
	        @ApiResponse(code = 500, message = "Internal server error") })
	      

	
	@RequestMapping(method = RequestMethod.DELETE, value= "/users/{id}")
	@ResponseBody
	public UserTest borrarId(@PathVariable int id) {
		
		return serviceHello.borrarCampo(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/users")
	@ResponseBody
	public UserTest agregarCampo(@RequestBody UserTest ut) {
		return serviceHello.agregarCampo(ut);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/update")
	@ResponseBody
	public UserTest update(@RequestBody UserTest ut) {
		return serviceHello.agregarCampo(ut);
	}
	
	
}
