package com.proyecto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Car;
import com.proyecto.model.Fuel;
import com.proyecto.model.User;

@Repository("fuelTypeDao")
@Transactional
public class FuelDaoImpl extends AbstractDao<Integer, Fuel> implements FuelDao {
 
	/** Función que encuentra combustibles
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Fuel> findFuel() {
		try {
			List<Fuel> fuelType = getEntityManager().createQuery("SELECT f FROM Fuel f ").getResultList();
			return fuelType;
		} catch (NoResultException ex) {
			return null;
		}
	}

	/** Función que encuentra combustibles por nombre
	 *
	 */
	public Fuel findFuelByName(String name) {

		try {
			Fuel f = (Fuel) getEntityManager().createQuery("SELECT f FROM Fuel f where f.fuelType = :fueltype")
					.setParameter("fueltype", name).getSingleResult();
			return f;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/** Función que encuentra combustibles por id
	 *
	 */
	public Fuel findFuelById(int id) {

		try {
			Fuel f = (Fuel) getEntityManager().createQuery("SELECT f FROM Fuel f where f.fuelType.id = :fueltype")
					.setParameter("fueltype", id).getSingleResult();
			return f;
		} catch (NoResultException e) {
			return null;
		}
	}

	/** Función que encuentra combustibles por nombre y los guarda
	 *
	 */
	@Override
	public Fuel save(Fuel f) {
		if (findFuelByName(f.getFuelType()) == null) {
			getEntityManager().persist(f);
		}
		return f;
	}

	/** Función que encuentra todos los combustibles
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<Fuel> findAllFuels() {
		List<Fuel> fuels = getEntityManager().createQuery("SELECT f FROM Fuel f ORDER BY f.id ASC")
				.getResultList();
		return fuels;
	}

	/** Función que elimina todos los combustible
	 *
	 */
	public void deleteById(String id) {
		Fuel f = (Fuel) getEntityManager().createQuery("SELECT f FROM Fuel f WHERE f.id = :id").setParameter("id", id)
				.getSingleResult();
		delete(f);
	}

	/** Función que encuentra combustibles por clave principal
	 *
	 */
	public Fuel getByPk(Integer key) {
		return getByKey(key);
	}

}