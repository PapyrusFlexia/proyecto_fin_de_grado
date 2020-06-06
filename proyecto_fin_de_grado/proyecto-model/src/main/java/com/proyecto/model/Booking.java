package com.proyecto.model;

import java.io.Serializable;
import java.util.Date;

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
	@Column(name = "PLACE", nullable = false)
	private String place;

	@NotNull
	@Column(name = "STARTDATE", nullable = false)
	private Date startdate;

	@NotNull
	@Column(name = "FINISHDATE", nullable = false)
	private Date finishdate;

	@NotNull
	@Column(name = "NUMBEROFUSERS", nullable = false)
	private int numberofusers;

	@NotNull
	@Column(name = "RESERVED", nullable = false)
	private boolean reserved;
	
	@NotNull
	@Column(name = "CARNAME", nullable = false)
	private String carname;

	public Booking() {

	}

	public Booking(int id, String place, Date startdate, Date finishdate, int numberofusers, boolean reserved,
			String carname) {
		super();
		this.id = id;
		this.place = place;
		this.startdate = startdate;
		this.finishdate = finishdate;
		this.numberofusers = numberofusers;
		this.reserved = reserved;
		this.carname = carname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public int getNumberofusers() {
		return numberofusers;
	}

	public void setNumberofusers(int numberofusers) {
		this.numberofusers = numberofusers;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", place=" + place + ", startdate=" + startdate + ", finishdate=" + finishdate
				+ ", numberofusers=" + numberofusers + ", reserved=" + reserved + ", carname=" + carname + "]";
	}

}