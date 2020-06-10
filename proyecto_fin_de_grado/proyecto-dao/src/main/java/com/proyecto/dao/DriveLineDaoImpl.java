package com.proyecto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.DriveLine;
import com.proyecto.model.User;

@Repository("driveLineDao")
@Transactional
public class DriveLineDaoImpl extends AbstractDao<Integer, DriveLine> implements DriveLineDao {

	/** Función que encuentra drivelines
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DriveLine> findDriveLines() {
		try {
			List<DriveLine> drivelines = getEntityManager().createQuery("SELECT dl FROM DriveLine dl ")
					.getResultList();
			return drivelines;
		} catch (NoResultException ex) {
			return null;
		}
	}
 
	/** Función que encuentra drivelines por nombre
	 *
	 */
	public DriveLine findDriveLineByName(String name) {

		try {
			DriveLine d = (DriveLine) getEntityManager()
					.createQuery("SELECT d FROM DriveLine d where d.driveLine = :driveLine")
					.setParameter("driveLine", name).getSingleResult();
			return d;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/** Función que encuentra drivelines por id
	 *
	 */
	public DriveLine findDriveLineById(int id) {

		try {
			DriveLine d = (DriveLine) getEntityManager()
					.createQuery("SELECT d FROM DriveLine d where d.driveLine.id = :driveLine")
					.setParameter("driveLine", id).getSingleResult();
			return d;
		} catch (NoResultException e) {
			return null;
		}
	}

	/** Función que encuentra drivelines por nombre y las guarda
	 *
	 */
	@Override
	public DriveLine save(DriveLine d) {
		if (findDriveLineByName(d.getDriveLine()) == null) {
			getEntityManager().persist(d);
		}
		return d;
	}

	/** Función que encuentra todas las drivelines
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DriveLine> findAllDriveLines() {
		List<DriveLine> drivelines = getEntityManager().createQuery("SELECT dl FROM DriveLine dl ORDER BY dl.id ASC")
				.getResultList();
		return drivelines;
	}

	/** Función que elimina drivelines por id
	 *
	 */
	public void deleteById(String id) {
		DriveLine dl = (DriveLine) getEntityManager().createQuery("SELECT dl FROM DriveLine dl WHERE dl.id = :id")
				.setParameter("id", id).getSingleResult();
		delete(dl);
	}

	/** Función que encuentra drivelines por clave principal
	 *
	 */
	public DriveLine getByPk(Integer key) {
		return getByKey(key);
	}

}