package com.practicas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MAKE")
public class Make implements Serializable{

	private static final long serialVersionUID = -4096888939812857252L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="MAKE", nullable=false)
	private String make;
	
	public Make() {
		super();
	}
	
	public Make(int id, String make) {
		super();
		this.id = id;
		this.make = make;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	@Override
	public String toString() {
		return "{id: "+id+",make: "+make+"}";
	}
	
	
}