package com.proyecto.dao;

import javax.persistence.Query;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Region;
import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

@Repository("regionDao")
@Transactional
public class RegionDaoImpl extends AbstractDao<Serializable, Region> implements RegionDao {

	public Region findRegionByName(String name) {

		try {
			Region r = (Region) getEntityManager().createQuery("SELECT r FROM Region r WHERE r.name = :name")
					.setParameter("name", name).getSingleResult();
			return r;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public long totalRegion() {
		long totalRegion = (long) getEntityManager().createQuery("SELECT COUNT (r.id) FROM Region r").getSingleResult();
		return totalRegion;
	}

	@Override
	public Region save(Region r) {
		Region r1 = findRegionByName(r.getRegionname());
		if (r1 == null) {
			persist(r);
		}
		return r1;
	}

	@SuppressWarnings("unchecked")
	public List<Region> findAllRegions() {
		List<Region> regions = getEntityManager().createQuery("SELECT r FROM Region r ORDER BY r.id ASC")
				.getResultList();
		return regions;
	}

	public void deleteById(String id) {
		Region region = (Region) getEntityManager().createQuery("SELECT r FROM Region r WHERE r.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(region);
	}

	public int update(int id, String name, int price) {

		int executed = getEntityManager().createQuery(
				"UPDATE Region r set r.id = :id, r.name = :name, r.price = :price WHERE b.id = :id")
				.setParameter("id", id).setParameter("name", name).setParameter("price", price).executeUpdate();

		return executed;
	}

	public Region getByPk(Integer key) {
		return getByKey(key);
	}

}