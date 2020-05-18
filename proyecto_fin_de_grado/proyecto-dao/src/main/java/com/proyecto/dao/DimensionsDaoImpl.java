package com.proyecto.dao;

import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Dimensions;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.Make;
import com.proyecto.model.User;

@Repository("dimensionsDao")
@Transactional
public class DimensionsDaoImpl extends AbstractDao<Serializable, Dimensions> implements DimensionsDao {

	public Dimensions findDimensionsByName(String name) {

		try {
			Dimensions r = (Dimensions) getEntityManager()
					.createQuery("SELECT d FROM Dimensions d WHERE d.name = :name").setParameter("name", name)
					.getSingleResult();
			return r;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public long totalDimensions() {
		long totalDimensions = (long) getEntityManager().createQuery("SELECT COUNT (d.id) FROM Dimensions d")
				.getSingleResult();
		return totalDimensions;
	}

	@Override
	public Dimensions save(Dimensions d) {
		Dimensions d1 = findDimensionsByName(d.getDimensionname());
		if (d1 == null) {
			persist(d);
		}
		return d1;
	}

	@SuppressWarnings("unchecked")
	public List<Dimensions> findAllDimensions() {
		List<Dimensions> dimensions = getEntityManager().createQuery("SELECT d FROM Dimensions d ORDER BY d.id ASC")
				.getResultList();
		return dimensions;
	}

	public void deleteById(String id) {
		Dimensions dimension = (Dimensions) getEntityManager()
				.createQuery("SELECT d FROM Dimensions d WHERE d.id = :id").setParameter("id", id).getSingleResult();
		delete(dimension);
	}

	public int update(int id, String name, int height, int length, int width) {

		int executed = getEntityManager().createQuery(
				"UPDATE Dimensions d set d.id = :id, d.name = :name, d.height = :height, d.length = :length, d.width = :width WHERE b.id = :id")
				.setParameter("id", id).setParameter("name", name).setParameter("height", height)
				.setParameter("length", length).setParameter("width", width).executeUpdate();

		return executed;
	}

	public Dimensions getByPk(Integer key) {
		return getByKey(key);
	}

}