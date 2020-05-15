package com.proyecto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DIMENSIONS")
public class Dimensions implements Serializable{

	private static final long serialVersionUID = 3988240899233372627L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="WIDTH", nullable=false)
	private int width;
	
	@NotNull
	@Column(name="LENGTH", nullable=false)
	private int length;
	
	@NotNull
	@Column(name="HEIGHT", nullable=false)
	private int height;
	
	public Dimensions() {
		
	}

	public Dimensions(int id, int width, int length, int height) {
		super();
		this.id = id;
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
