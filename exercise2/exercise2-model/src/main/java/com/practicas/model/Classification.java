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
@Table(name="CLASSIFICATION")
public class Classification implements Serializable{
	
	private static final long serialVersionUID = -8552078235100626997L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="CLASSIFICATION", nullable=false)
	private String classification;
	
	public Classification() {
		super();
	}
	
	public Classification(int id, String classification) {
		super();
		this.id = id;
		this.classification = classification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return "Classification [id=" + id + ", classification=" + classification + ", getId()=" + getId()
				+ ", getClassification()=" + getClassification() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}