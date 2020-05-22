package com.proyecto.dao;

import javax.persistence.Query;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.CarImage;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

@Repository("carImageDao")
@Transactional
public class CarImageDaoImpl extends AbstractDao<Serializable, CarImage> implements CarImageDao {

	public CarImage findCarImageByName(String name) {

		try {
			CarImage ci = (CarImage) getEntityManager().createQuery("SELECT ci FROM CarImage ci WHERE ci.name = :name")
					.setParameter("name", name).getSingleResult();
			return ci;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public long totalCarImage() {
		long totalCarImage = (long) getEntityManager().createQuery("SELECT COUNT (ci.id) FROM CarImage ci")
				.getSingleResult();
		return totalCarImage;
	}

	@Override
	public CarImage save(CarImage ci) {
		CarImage ci1 = findCarImageByName(ci.getName());
		if (ci1 == null) {
			persist(ci);
		}
		return ci1;
	}

	@SuppressWarnings("unchecked")
	public List<CarImage> findAllCarImages() {
		List<CarImage> carImages = getEntityManager().createQuery("SELECT ci FROM CarImage ci ORDER BY ci.id ASC")
				.getResultList();
		return carImages;
	}

	public void deleteById(String id) {
		CarImage region = (CarImage) getEntityManager().createQuery("SELECT ci FROM CarImage ci WHERE ci.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(region);
	}

	public int update(int id, int image, String name, int car_id) {

		int executed = getEntityManager().createQuery(
				"UPDATE CarImage ci set ci.id = :id, ci.image = :image, ci.name = :name, ci.car_id = :car_id WHERE b.id = :id")
				.setParameter("id", id).setParameter("image", image).setParameter("name", name)
				.setParameter("car_id", car_id).executeUpdate();

		return executed;
	}

	public CarImage getByPk(Integer key) {
		return getByKey(key);
	}

}