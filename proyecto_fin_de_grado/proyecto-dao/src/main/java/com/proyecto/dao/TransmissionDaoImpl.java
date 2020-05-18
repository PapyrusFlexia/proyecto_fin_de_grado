package com.proyecto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Car;
import com.proyecto.model.Transmission;
import com.proyecto.model.User;

@Repository("transmissionDao")
@Transactional
public class TransmissionDaoImpl extends AbstractDao<Integer, Transmission> implements TransmissionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Transmission> findTransmissions() {
		try {
			List<Transmission> trans = getEntityManager().createQuery("SELECT t FROM Transmission t ").getResultList();
			return trans;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Transmission findTransmissionByName(String name) {

		try {
			Transmission t = (Transmission) getEntityManager()
					.createQuery("SELECT t FROM Transmission t where t.transmission = :transmission")
					.setParameter("transmission", name).getSingleResult();
			return t;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Transmission save(Transmission t) {
		if (findTransmissionByName(t.getTransmission()) == null) {
			return persist(t);
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<Transmission> findAllTransmissions() {
		List<Transmission> transmissions = getEntityManager().createQuery("SELECT t FROM Transmission t ORDER BY t.id ASC")
				.getResultList();
		return transmissions;
	}

	public void deleteById(String id) {
		Transmission t = (Transmission) getEntityManager().createQuery("SELECT t FROM Transmission t WHERE t.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(t);
	}

	public Transmission getByPk(Integer key) {
		return getByKey(key);
	}

}