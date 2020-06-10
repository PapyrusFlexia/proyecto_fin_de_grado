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

	/** Función que encuentra imágenes de los coches por nombre
	 * @param name
	 * @return
	 */
	public CarImage findCarImageByName(String name) {

		try {
			CarImage ci = (CarImage) getEntityManager().createQuery("SELECT ci FROM CarImage ci WHERE ci.name = :name")
					.setParameter("name", name).getSingleResult();
			return ci;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/** Función que encuentra imágenes de los coches por el id del coche
	 *
	 */
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
	
	/** Función que encuentra imágenes de los coches
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getCarImages() { 

		List<String> listCarImages = getEntityManager().createQuery("SELECT DISTINCT ci FROM CarImage ci")
				.getResultList();

		return listCarImages;
	}
	
	/** Función que encuentra todas las imágenes de los coches 
	 *
	 */
	@Override
	public long totalCarImage() {
		long totalCarImage = (long) getEntityManager().createQuery("SELECT COUNT (ci.id) FROM CarImage ci")
				.getSingleResult();
		return totalCarImage;
	}

	/** Función que hace un persist del las imágenes de los coches
	 *
	 */
	@Override
	public CarImage saveImage(CarImage ci) {

			return persist(ci);

	}

	/** Función que encuentra todas imágenes de los coches
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<CarImage> findAllCarImages() {
		List<CarImage> carImages = getEntityManager().createQuery("SELECT ci FROM CarImage ci ORDER BY ci.id ASC")
				.getResultList();
		return carImages;
	}

	/** Función que elimina imágenes de los coches por id
	 *
	 */
	public void deleteById(String id) {
		CarImage region = (CarImage) getEntityManager().createQuery("SELECT ci FROM CarImage ci WHERE ci.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(region);
	}


	/** Función que encuentra imágenes de los coches por la clave principal
	 *
	 */
	public CarImage getByPk(Integer key) {
		return getByKey(key);
	}

	

}