package com.proyecto.model;

import java.util.List;
import java.util.Map;

public class PaginaCompleta {

	private List<Car> cars;
	private Map<String, List<?>> filters;
	private long iTotalRecords;
	private long iTotalDisplayRecords;
	private String sEcho;
	private String sColumns;
	private List<Car> aaData;

	public PaginaCompleta() {

	}

	public PaginaCompleta(List<Car> cars, Map<String, List<?>> filters, int iTotalRecords, int iTotalDisplayRecords,
			String sEcho, String sColumns, List<Car> aaData) {
		super();
		this.cars = cars;
		this.filters = filters;
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.sEcho = sEcho;
		this.sColumns = sColumns;
		this.aaData = aaData;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Map<String, List<?>> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, List<?>> filters) {
		this.filters = filters;
	}

	public long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public List<Car> getAaData() {
		return aaData;
	}

	public void setAaData(List<Car> aaData) {
		this.aaData = aaData;
	}

	@Override
	public String toString() {
		return "PaginaCompleta [cars=" + cars + ", filters=" + filters + ", iTotalRecords=" + iTotalRecords
				+ ", iTotalDisplayRecords=" + iTotalDisplayRecords + ", sEcho=" + sEcho + ", sColumns=" + sColumns
				+ ", aaData=" + aaData + "]";
	}

}