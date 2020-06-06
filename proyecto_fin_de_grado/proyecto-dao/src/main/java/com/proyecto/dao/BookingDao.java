package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Booking;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

public interface BookingDao {

	

	Booking save(Booking b);
	
	Booking saveBooking(Booking b);

	int update(int id, String place, int startdate, int finishdate, int numberofusers, boolean reserved);
	
	long totalBooking();

	void deleteById(String id);
	
	List<Booking> findAllBookings();

	Booking getByPk(Integer key);
}
