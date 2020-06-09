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
import com.proyecto.model.CarImage;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

@Repository("bookingDao")
@Transactional
public class BookingDaoImpl extends AbstractDao<Serializable, Booking> implements BookingDao {

	/**
	 * Función que encuentra reservas por el booleano reserved
	 * 
	 * @param reserved
	 * @return
	 */
	public Booking findBookingByReserved(Boolean reserved) {

		try {
			Booking b = (Booking) getEntityManager().createQuery("SELECT b FROM Booking b WHERE b.reserved = :reserved")
					.setParameter("reserved", reserved).getSingleResult();
			return b;
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * Función que encuentra todas las reservas
	 *
	 */
	@Override
	public long totalBooking() {
		long totalBooking = (long) getEntityManager().createQuery("SELECT COUNT (b.id) FROM Booking b")
				.getSingleResult();
		return totalBooking;
	}

	/**
	 * Función que hace un persist de reservas
	 *
	 */
	@Override
	public Booking saveBooking(Booking b) {

		return persist(b);

	}

	/**
	 * Función que busca las reservas por el booleano reserved y hace un persist de
	 * ellas
	 *
	 */
	@Override
	public Booking save(Booking b) {
		Booking b1 = findBookingByReserved(b.isReserved());
		if (b1 == null) {
			persist(b);
		}
		return b1;
	}

	/** Función que busca todas las reservas en orden
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<Booking> findAllBookings() {
		List<Booking> cars = getEntityManager().createQuery("SELECT b FROM Booking b ORDER BY b.id ASC")
				.getResultList();
		return cars;
	}

	/** Función que borra las reservas por id
	 *
	 */
	public void deleteById(String id) {
		Booking booking = (Booking) getEntityManager().createQuery("SELECT b FROM Booking b WHERE b.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(booking);
	}

	/** Función que actualiza las reservas
	 *
	 */
	public int update(int id, String place, int startdate, int finishdate, int numberofusers, boolean reserved) {

		int executed = getEntityManager().createQuery(
				"UPDATE Booking b set b.place = :place, b.startdate = :startdate, b.finishdate = :finishdate, b.numberofusers = :numberofusers, b.reserved = :reserved WHERE b.id = :id")
				.setParameter("id", id).setParameter("place", place).setParameter("startdate", startdate)
				.setParameter("finishdate", finishdate).setParameter("numberofusers", numberofusers).executeUpdate();

		return executed;
	}

	/** Función que recoge el id autogenerado
	 *
	 */
	public Booking getByPk(Integer key) {
		return getByKey(key);
	}

}