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
@Table(name = "REGION")
public class Region implements Serializable {

	private static final long serialVersionUID = 3988240899233372627L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name = "REGIONNAME", nullable = false) /////////// NUEVO
	private String regionname;

	@NotNull
	@Column(name = "PRICE", nullable = false)
	private int price;

	public Region() {

	}

	public Region(int id, String regionname, int price) {
		super();
		this.id = id;
		this.regionname = regionname;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegionname() {
		return regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", regionname=" + regionname + ", price=" + price + "]";
	}

}