package com.proyecto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.User;

@Repository("classificationDao")
@Transactional
public class ClassificationDaoImpl extends AbstractDao<Integer, Classification> implements ClassificationDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Classification> findClassifications() {
		try {
			List<Classification> classifications = getEntityManager().createQuery("SELECT c FROM Classification c ")
					.getResultList();
			return classifications;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Classification findClassificationByName(String name) {

		try {
			Classification c = (Classification) getEntityManager()
					.createQuery("SELECT c FROM Classification c where c.classification = :classification")
					.setParameter("classification", name).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void deleteById(String id) {
		Classification cl = (Classification) getEntityManager()
				.createQuery("SELECT cl FROM Classification cl WHERE cl.id = :id").setParameter("id", id)
				.getSingleResult();
		delete(cl);
	}

	@Override
	public Classification save(Classification c) {
		if (findClassificationByName(c.getClassification()) == null) {
			getEntityManager().persist(c);
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Classification> findAllClassifications() {
		List<Classification> classifications = getEntityManager().createQuery("SELECT cl FROM Classification cl ORDER BY cl.id ASC")
				.getResultList();
		return classifications;
	}

	public Classification getByPk(Integer key) {
		return getByKey(key);
	}

}