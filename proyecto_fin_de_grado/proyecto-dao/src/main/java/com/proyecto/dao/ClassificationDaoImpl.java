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

	/** Función que encuentra clasificaciones
	 *
	 */
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

	/** Función que encuentra clasificaciones por nombre
	 *
	 */
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
	
	/** Función que encuentra clasificaciones por id
	 *
	 */
	public Classification findClassificationById(int id) {

		try {
			Classification c = (Classification) getEntityManager()
					.createQuery("SELECT c FROM Classification c where c.classification.id = :classification")
					.setParameter("classification", id).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}

	/** Función que elimina clasificaciones por id
	 *
	 */
	public void deleteById(String id) {
		Classification cl = (Classification) getEntityManager()
				.createQuery("SELECT cl FROM Classification cl WHERE cl.id = :id").setParameter("id", id)
				.getSingleResult();
		delete(cl);
	}

	/** Función que encuentra clasificaciones por nombre y las guarda
	 *
	 */
	@Override
	public Classification save(Classification c) {
		if (findClassificationByName(c.getClassification()) == null) {
			getEntityManager().persist(c);
		}
		return c;
	}

	/** Función que encuentra todas las clasificaciones
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<Classification> findAllClassifications() {
		List<Classification> classifications = getEntityManager().createQuery("SELECT cl FROM Classification cl ORDER BY cl.id ASC")
				.getResultList();
		return classifications;
	}

	/** Función que encuentra clasificaciones por clave principal
	 *
	 */
	public Classification getByPk(Integer key) {
		return getByKey(key);
	}

}