package com.proyecto.dao;

import javax.persistence.Query;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Rating;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

@Repository("ratingDao")
@Transactional
public class RatingDaoImpl extends AbstractDao<Serializable, Rating> implements RatingDao {
	
	@PersistenceContext
	EntityManager entityManager;

	public Rating findRatingByRating(Integer rating) {

		try {
			Rating r = (Rating) getEntityManager().createQuery("SELECT r FROM Rating r WHERE r.rating = :rating")
					.setParameter("rating", rating).getSingleResult();
			return r;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Rating getRatingByBookingId(int bookingid) {

		try {
			Rating r = (Rating) getEntityManager().createQuery("SELECT r FROM Rating r WHERE r.bookingid = :bookingid")
					.setParameter("bookingid", bookingid).getSingleResult();
			return r;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getBookingRatings() { 

		List<String> listRatings = getEntityManager().createQuery("SELECT DISTINCT r FROM Rating r")
				.getResultList();

		return listRatings;
	}
	
	@Override
	public long totalRating() {
		long totalRating = (long) getEntityManager().createQuery("SELECT COUNT (r.id) FROM Rating r")
				.getSingleResult();
		return totalRating;
	}

	@Override
	public Rating saveRating(Rating r) {

			return persist(r);

	}

	@SuppressWarnings("unchecked")
	public List<Rating> findAllRatings() {
		List<Rating> carImages = getEntityManager().createQuery("SELECT r FROM Rating r ORDER BY r.id ASC")
				.getResultList();
		return carImages;
	}

	public void deleteById(String id) {
		Rating rating = (Rating) getEntityManager().createQuery("SELECT r FROM Rating r WHERE r.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(rating);
	}


	public Rating getByPk(Integer key) {
		return getByKey(key);
	}

	

}