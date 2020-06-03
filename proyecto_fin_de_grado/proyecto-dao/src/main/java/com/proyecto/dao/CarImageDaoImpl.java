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
	@SuppressWarnings("unchecked")
	public CarImage getCarImageByCarId(int carid) {

		try {
			CarImage ci = (CarImage) getEntityManager().createQuery("SELECT ci FROM CarImage ci WHERE ci.carid = :carid")
					.setParameter("carid", carid).getSingleResult();
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
	public CarImage saveImage(CarImage ci) {

			return persist(ci);

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


	public CarImage getByPk(Integer key) {
		return getByKey(key);
	}

	

}