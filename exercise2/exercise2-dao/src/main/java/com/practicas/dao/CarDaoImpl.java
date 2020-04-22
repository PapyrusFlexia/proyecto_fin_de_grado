package com.practicas.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.practicas.model.Car;

@Repository("carDao")
public class CarDaoImpl extends AbstractDao<Serializable, Car> implements CarDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCars(int start, int end) {
		
		List<Car> listCar = getEntityManager()
				.createQuery("SELECT c FROM Car c ORDER BY c.id ASC LIMIT :start,:end")
				.setParameter("start", start)
				.setParameter("end", end)
				.getResultList();
		
		return listCar;
	}

	@Override
	public Car save(Car c) {
		persist(c);
		return c;
	}

}