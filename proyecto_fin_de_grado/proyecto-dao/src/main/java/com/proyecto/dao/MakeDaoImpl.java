package com.proyecto.dao;

import java.util.List;


import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Car;
import com.proyecto.model.User;

@Repository("makeDao")
@Transactional
public class MakeDaoImpl extends AbstractDao<Integer, Car> implements MakeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> findMakes() {
		try {
			List<Car> makes = getEntityManager().createQuery("SELECT m FROM Car m ").getResultList();
			return makes;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Car findMakeByName(String name) {

		try {
			Car make = (Car) getEntityManager().createQuery("SELECT m FROM Car m where m.make = :make")
					.setParameter("make", name).getSingleResult();
			return make;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Car save(Car m) {
		if (findMakeByName(m.getMake()) == null) {
			getEntityManager().persist(m);
		}
		return m;
	}

	@SuppressWarnings("unchecked")
	public List<Car> findAllMakes() {
		List<Car> makes = getEntityManager().createQuery("SELECT m FROM Car m ORDER BY m.id ASC")
				.getResultList();
		return makes;
	}

	public void deleteById(String id) {
		Car m = (Car) getEntityManager().createQuery("SELECT m FROM Car m WHERE m.id = :id").setParameter("id", id)
				.getSingleResult();
		delete(m);
	}

	public Car getByPk(Integer key) {
		return getByKey(key);
	}
}