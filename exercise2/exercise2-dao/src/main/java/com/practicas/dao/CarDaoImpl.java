package com.practicas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.Car;

@Repository("carDao")
@Transactional
public class CarDaoImpl extends AbstractDao<Serializable, Car> implements CarDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCars(int start, int end) {
		
		List<Car> listCar = getEntityManager()
				.createQuery("SELECT c FROM Car c ORDER BY c.id ASC")
				.getResultList();
		
		return listCar;
	}
	
	/** @Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCars(int start, int end) {
		
		List<Car> listCar = getEntityManager()
				.createQuery("SELECT c FROM Car c ORDER BY c.id ASC LIMIT :start,:end")
				.setParameter("start", start)
				.setParameter("end", end)
				.getResultList();
		
		return listCar;
	} */
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsNumberOfForwardGears() {
		
		List<Integer> listNumberOfForwardGears = getEntityManager()
				.createQuery("SELECT DISTINCT c.NUMBEROFFORWARDGEARS FROM Car c ORDER BY c.NUMBEROFFORWARDGEARS")
				.getResultList();
		
		return listNumberOfForwardGears;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsYears() { /////////////// CARDAO
		
		List<Integer> listYears = getEntityManager()
				.createQuery("SELECT DISTINCT c.YEAR FROM Car c ORDER BY c.YEAR")
				.getResultList();
		
		return listYears;
	}
	
	public Car findCarById(int id) {
		
		try {
			Car c = (Car) getEntityManager()
					.createQuery("SELECT c FROM Car c WHERE c.id = :id")
					.setParameter("id", id).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	
	public Car findCarByName(String name) {
		
		try {
			Car c = (Car) getEntityManager()
					.createQuery("SELECT c FROM Car c WHERE c.name = :name")
					.setParameter("name", name).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public long totalCar() {
		long totalCar = (long) getEntityManager().createQuery("SELECT COUNT (c.id) FROM Car c").getSingleResult();
		return totalCar;
	}

	@Override
	public Car save(Car c) {
		Car c1 = findCarByName(c.getName());
		if(c1 == null) {
			persist(c);
		}
		return c1;
	}
	
// ErrorNo EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call
}