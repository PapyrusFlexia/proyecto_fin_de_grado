package com.practicas.dao;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.Car;

@Repository("carDao")
@Transactional
public class CarDaoImpl extends AbstractDao<Serializable, Car> implements CarDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCars(int start, int end) { ///////////////// !!!!!!!!!!!!!!!!!!!!

		List<Car> listCar = getEntityManager().createQuery("SELECT c FROM Car c ORDER BY c.id ASC").getResultList();

		return listCar;
	}

	public List<Car> findPaginationCarsEjemplo(int start, int end, Map<String, Object> params, String order,
			String ascDesc) {

		StringBuffer sb = new StringBuffer("SELECT c FROM Car c WHERE ");
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			sb.append(" AND ");
			sb.append(entry.getKey());
			sb.append(" = ");
			sb.append(" :");
			sb.append(entry.getKey());
		}

		if (order != null && !order.equals("")) {
			sb.append(" ORDER BY " + order + "," + ascDesc);
		}
		if (start > 0) {
			sb.append(" LIMIT " + start + "," + end);
		}
		if (end > 0) {
			sb.append(" , " + end);
		}
		Query q = getEntityManager().createQuery(sb.toString());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() instanceof String) {
				q.setParameter(entry.getKey(), (String) entry.getValue());
			} else if (entry.getValue() instanceof Integer) {
				q.setParameter(entry.getKey(), (Integer) entry.getValue());
			}
		}
		List<Car> listCar = q.getResultList();

		return listCar;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsNumberOfForwardGears() {

		List<Integer> listNumberOfForwardGears = getEntityManager()
				.createQuery("SELECT DISTINCT c.NUMBEROFFORWARDGEARS FROM Car c ORDER BY c.NUMBEROFFORWARDGEARS")
				.getResultList();

		return listNumberOfForwardGears;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsYears() { /////////////// CARDAO

		List<Integer> listYears = getEntityManager().createQuery("SELECT DISTINCT c.YEAR FROM Car c ORDER BY c.YEAR")
				.getResultList();

		return listYears;
	}

	public Car findCarById(int id) {

		try {
			Car c = (Car) getEntityManager().createQuery("SELECT c FROM Car c WHERE c.id = :id").setParameter("id", id)
					.getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Car findCarByName(String name) {

		try {
			Car c = (Car) getEntityManager().createQuery("SELECT c FROM Car c WHERE c.name = :name")
					.setParameter("name", name).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public long totalCar() {
		long totalCar = (long) getEntityManager().createQuery("SELECT COUNT (c.id) FROM Car c").getSingleResult();
		return totalCar;
	}

	@Override
	public Car save(Car c) {
		Car c1 = findCarByName(c.getName());
		if (c1 == null) {
			persist(c);
		}
		return c1;
	}

	/**public Car update(Car c) {
		return update(c);
	}*/

	public int update(int id, String transmission, String engineType, int horsepower, int torque, boolean hybrid,
			int numberofforwardgears, String driveline, String make, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType) {

		int executed = getEntityManager().createQuery(
				"UPDATE Car c set c.transmission.id = :transmission, c.engineType = :engineType, c.horsepower = :horsepower, c.torque = :torque, c.hybrid = :hybrid, c.numberofforwardgears = :numberofforwardgears, c.driveline.id = :driveline, c.make.id = :make, c.modelyear = :modelyear, c.name = :name, c.classification.id = :classification, c.year = :year, c.width = :width, c.length = :length, c.height = :height, c.highwaympg = :highwaympg, c.citymph = :citymph, c.fuelType.id = :fuelType WHERE c.id = :id")
				.setParameter("id", id)
				.setParameter("transmission", Integer.valueOf(transmission))
				.setParameter("engineType", engineType)
				.setParameter("horsepower", horsepower)
				.setParameter("torque", torque)
				.setParameter("hybrid", hybrid)
				.setParameter("numberofforwardgears", numberofforwardgears)
				.setParameter("driveline", Integer.valueOf(driveline))
				.setParameter("make", Integer.valueOf(make))
				.setParameter("modelyear", modelyear)
				.setParameter("name", name)
				.setParameter("classification", Integer.valueOf(classification))
				.setParameter("year", year)
				.setParameter("width", width)
				.setParameter("length", length)
				.setParameter("height", height)
				.setParameter("highwaympg", highwaympg)
				.setParameter("citymph", citymph)
				.setParameter("fuelType", Integer.valueOf(fuelType))
				.executeUpdate();

		return executed;
	}

	/**
	 * Query check = getEntityManager() .createQuery("SELECT c FROM Car c WHERE name
	 * = :name and engineType = :engineType") .setParameter("name",
	 * params.get("c.name")).setParameter("engineType", params.get("c.enginetype"));
	 */
	public Car getByPk(Integer key) {
		return getByKey(key);
	}

}