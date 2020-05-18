package com.proyecto.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOKING")
public class Booking implements Serializable {

	private static final long serialVersionUID = 3988240899233372627L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(name = "NICKNAME", nullable = false)
	private String nickname;

	@NotNull
	@Column(name = "PLACE", nullable = false)
	private String place;

	@NotNull
	@Column(name = "STARTDATE", nullable = false)
	private int startdate;

	@NotNull
	@Column(name = "FINISHDATE", nullable = false)
	private int finishdate;

	@NotNull
	@Column(name = "NUMBEROFUSERS", nullable = false)
	private int numberofusers;

	@NotNull
	@Column(name = "RATING", nullable = false) ///////// CAMBIADO
	private int rating;

	@NotNull
	@Column(name = "RESERVED", nullable = false) ///////// NUEVO
	private boolean reserved;

	public Booking() {

	}

	public Booking(int id, String nickname, String place, int startdate, int finishdate, int numberofusers, int rating,
			boolean reserved) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.place = place;
		this.startdate = startdate;
		this.finishdate = finishdate;
		this.numberofusers = numberofusers;
		this.rating = rating;
		this.reserved = reserved;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getStartdate() {
		return startdate;
	}

	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}

	public int getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(int finishdate) {
		this.finishdate = finishdate;
	}

	public int getNumberofusers() {
		return numberofusers;
	}

	public void setNumberofusers(int numberofusers) {
		this.numberofusers = numberofusers;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", nickname=" + nickname + ", place=" + place + ", startdate=" + startdate
				+ ", finishdate=" + finishdate + ", numberofusers=" + numberofusers + ", rating=" + rating
				+ ", reserved=" + reserved + "]";
	}

}