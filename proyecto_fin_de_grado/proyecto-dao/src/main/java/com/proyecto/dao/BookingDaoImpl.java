package com.proyecto.dao;

import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Booking;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.Make;
import com.proyecto.model.User;

@Repository("bookingDao")
@Transactional
public class BookingDaoImpl extends AbstractDao<Serializable, Booking> implements BookingDao {

	public Booking findBookingByReserved(Boolean reserved) {

		try {
			Booking b = (Booking) getEntityManager().createQuery("SELECT b FROM Booking b WHERE b.reserved = :reserved")
					.setParameter("reserved", reserved).getSingleResult();
			return b;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public long totalBooking() {
		long totalBooking = (long) getEntityManager().createQuery("SELECT COUNT (b.id) FROM Booking b").getSingleResult();
		return totalBooking;
	}

	@Override
	public Booking save(Booking b) {
		Booking b1 = findBookingByReserved(b.isReserved());
		if (b1 == null) {
			persist(b);
		}
		return b1;
	}

	@SuppressWarnings("unchecked")
	public List<Booking> findAllBookings() {
		List<Booking> cars = getEntityManager().createQuery("SELECT b FROM Booking b ORDER BY b.id ASC")
				.getResultList();
		return cars;
	}

	public void deleteById(String id) {
		Booking booking = (Booking) getEntityManager().createQuery("SELECT b FROM Booking b WHERE b.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(booking);
	}

	public int update(int id, String nickname, String place, int startdate, int finishdate, int numberofusers,
			int rating, boolean reserved) {

		int executed = getEntityManager().createQuery(
				"UPDATE Booking b set b.nickname = :nickname, b.place = :place, b.startdate = :startdate, b.finishdate = :finishdate, b.numberofusers = :numberofusers, b.rating = :rating, b.reserved = :reserved WHERE b.id = :id")
				.setParameter("id", id).setParameter("nickname", nickname).setParameter("place", place)
				.setParameter("startdate", startdate).setParameter("finishdate", finishdate)
				.setParameter("numberofusers", numberofusers).setParameter("rating", rating).executeUpdate();

		return executed;
	}

	public Booking getByPk(Integer key) {
		return getByKey(key);
	}

}