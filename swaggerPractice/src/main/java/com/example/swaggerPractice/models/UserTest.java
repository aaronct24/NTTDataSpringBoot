package com.example.swaggerPractice.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value = "Modelos")
@Entity
@Table ( name = "test")
public class UserTest {
	@Id
	private int id;
	@ApiModelProperty(value = "Nombre de usuario", example= "Manolo")
	@NotEmpty(message = "es necesario introducir el nombre de usuario")
	private String name;
	
	@ApiModelProperty(value = "Fecha nacimiento" ,example= "2000-01-11")
	@NotNull(message = "La fecha no puede ir vacia")
	private Date fecha;
	
	//constructor vacio.
	public UserTest() {
		
	}
	
	
	//Getter y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
	
}
