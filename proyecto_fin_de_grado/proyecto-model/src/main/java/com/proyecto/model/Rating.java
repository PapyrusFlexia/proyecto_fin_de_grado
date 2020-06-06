package com.proyecto.model;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Rating implements Serializable {

	private static final long serialVersionUID = -2071600755316070507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private Integer rating;
	private Integer bookingid;
	
	public Rating() {
		
	}
	
	public Rating(int id, Integer rating, Integer bookingid) {
		super();
		this.id = id;
		this.rating = rating;
		this.bookingid = bookingid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", bookingid=" + bookingid + "]";
	}

}