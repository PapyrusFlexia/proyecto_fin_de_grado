package com.proyecto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Car;
import com.proyecto.model.Make;
import com.proyecto.model.User;

@Repository("makeDao")
@Transactional
public class MakeDaoImpl extends AbstractDao<Integer, Make> implements MakeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Make> findMakes() {
		try {
			List<Make> makes = getEntityManager().createQuery("SELECT m FROM Make m ").getResultList();
			return makes;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Make findMakeByName(String name) {

		try {
			Make make = (Make) getEntityManager().createQuery("SELECT m FROM Make m where m.make = :make")
					.setParameter("make", name).getSingleResult();
			return make;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Make save(Make m) {
		if (findMakeByName(m.getMake()) == null) {
			getEntityManager().persist(m);
		}
		return m;
	}

	@SuppressWarnings("unchecked")
	public List<Make> findAllMakes() {
		List<Make> makes = getEntityManager().createQuery("SELECT m FROM Make m ORDER BY m.id ASC")
				.getResultList();
		return makes;
	}

	public void deleteById(String id) {
		Make m = (Make) getEntityManager().createQuery("SELECT m FROM Make m WHERE m.id = :id").setParameter("id", id)
				.getSingleResult();
		delete(m);
	}

	public Make getByPk(Integer key) {
		return getByKey(key);
	}
}