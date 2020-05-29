package com.proyecto.dao;

import javax.persistence.Query;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Engine;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

@Repository("engineDao")
@Transactional
public class EngineDaoImpl extends AbstractDao<Serializable, Engine> implements EngineDao {

	public Engine findEngineByEngineType(String enginetype) {

		try {
			Engine e = (Engine) getEntityManager()
					.createQuery("SELECT e FROM Engine e WHERE e.enginetype = :enginetype")
					.setParameter("enginetype", enginetype).getSingleResult();
			return e;
		} catch (NoResultException e) {
			return null;
		}
	}


	
	@Override
	public long totalEngine() {
		long totalEngine = (long) getEntityManager().createQuery("SELECT COUNT (e.id) FROM Engine e").getSingleResult();
		return totalEngine;
	}

	@Override
	public Engine save(Engine e) {
		Engine e1 = findEngineByEngineType(e.getEnginetype());
		if (e1 == null) {
			persist(e);
		}
		return e1;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Engine> findAllEngines() {
		List<Engine> engines = getEntityManager().createQuery("SELECT e FROM Engine e ORDER BY e.id ASC")
				.getResultList();
		return engines;
	}

	public void deleteById(String id) {
		Engine engine = (Engine) getEntityManager().createQuery("SELECT e FROM Engine e WHERE e.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(engine);
	}

	public int update(int id, String driveline, String enginetype, Boolean hybrid, int numberofforwardgears,
			String transmission, int horsepower, int torque) {

		int executed = getEntityManager().createQuery(
				"UPDATE Engine e set e.id = :id, e.driveline = :driveline, e.enginetype = :enginetype, e.hybrid = :hybrid, e.numberofforwardgears = :numberofforwardgears, e.transmission = :transmission, e.horsepower = :horsepower, e.torque = :torque WHERE b.id = :id")
				.setParameter("id", id).setParameter("driveline", driveline).setParameter("enginetype", enginetype)
				.setParameter("hybrid", hybrid).setParameter("numberofforwardgears", numberofforwardgears)
				.setParameter("transmission", transmission).setParameter("horsepower", horsepower)
				.setParameter("torque", torque).executeUpdate();

		return executed;
	}

	public Engine getByPk(Integer key) {
		return getByKey(key);
	}

}