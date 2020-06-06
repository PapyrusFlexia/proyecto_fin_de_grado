package com.proyecto.dao;

import java.util.List;


import com.proyecto.model.Rating;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

public interface RatingDao {

	

	Rating saveRating(Rating r);
	
	Rating getRatingByBookingId(int carid);
	
	long totalRating();
	
	public List<String> getBookingRatings();

	void deleteById(String id);
	
	List<Rating> findAllRatings();

	Rating getByPk(Integer key);
}
