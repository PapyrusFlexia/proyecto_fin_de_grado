package com.proyecto.dao;

import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Car;
import com.proyecto.model.Classification;
import com.proyecto.model.Engine;
import com.proyecto.model.User;

@Repository("carDao")
@Transactional
public class CarDaoImpl extends AbstractDao<Serializable, Car> implements CarDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCars(int pageSize, int paginaActual) {
		int pageCalc = paginaActual - 1;
		if (pageCalc < 0) {
			pageCalc = 0;
		}

		List<Car> listCar = getEntityManager().createQuery("SELECT c FROM Car c ORDER BY c.id ASC")
				.setFirstResult(pageCalc * pageSize) // pagesize numero de coches en la pagina
				.setMaxResults(pageSize).getResultList();

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
				.createQuery("SELECT DISTINCT c.numberofforwardgears FROM Car c ORDER BY c.numberofforwardgears")
				.getResultList();

		return listNumberOfForwardGears;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsYears() { /////////////// CARDAO

		List<Integer> listYears = getEntityManager().createQuery("SELECT DISTINCT c.year FROM Car c ORDER BY c.year")
				.getResultList();

		return listYears;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getCarsMakes() { /////////////// CARDAO

		List<String> listMakes = getEntityManager().createQuery("SELECT DISTINCT c.make FROM Car c ORDER BY c.make")
				.getResultList();

		return listMakes;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> getCarsMakesFilter(int m) {

		try {
			List<Car> listCarsMakes = getEntityManager().createQuery("SELECT c from Car c where c.make.id = :make")
					.setParameter("make", m).getResultList();

			return listCarsMakes;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsId() {

		List<Integer> listId = getEntityManager().createQuery("SELECT DISTINCT c.id FROM Car c ORDER BY c.id")
				.getResultList();

		return listId;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsPk() {

		List<Integer> listPk = getEntityManager().createQuery("SELECT DISTINCT c.pk FROM Car c ORDER BY c.pk")
				.getResultList();

		return listPk;
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

	public List<Car> findYearByName(int name) {

		try {
			List<Car> year = (List<Car>) getEntityManager().createQuery("SELECT c FROM Car c where c.year = :year")
					.setParameter("year", name).getResultList();
			return year;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Car> findMakeByName(String name) {

		try {
			List<Car> make = (List<Car>) getEntityManager().createQuery("SELECT c FROM Car c where c.make = :make")
					.setParameter("make", name).getResultList();
			return make;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Boolean> getCarsHybrids() { 

		List<Boolean> listCarsHybrids = getEntityManager()
				.createQuery("SELECT DISTINCT c.hybrid FROM Car c ORDER BY c.hybrid").getResultList();

		return listCarsHybrids;
	}

public List<Car> findHybridByName(Boolean name) {

	try {
		List<Car> hybrid = (List<Car>) getEntityManager()
				.createQuery("SELECT c FROM Car c where c.hybrid = :hybrid").setParameter("hybrid", name)
				.getResultList();
		return hybrid;
	} catch (NoResultException e) {
		return null;
	}
}

	public List<Car> findClassificationByName(int name) {

		try {
			List<Car> c = (List<Car>) getEntityManager()
					.createQuery("SELECT c FROM Classification c where c.classification.id = :classification")
					.setParameter("classification", name).getResultList();
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

	// CREAR METODOS PARA LOS FILTROS //////////////

	@Override
	public Car save(Car c) {
		Car c1 = findCarByName(c.getName());
		if (c1 == null) {
			persist(c);
		}
		return c1;
	}

	@SuppressWarnings("unchecked")
	public List<Car> findAllCars() {
		List<Car> cars = getEntityManager().createQuery("SELECT c FROM Car c ORDER BY c.id ASC").getResultList();
		return cars;
	}

	public void deleteById(String id) {
		Car car = (Car) getEntityManager().createQuery("SELECT c FROM Car c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		delete(car);
	}

	/**
	 * public Car update(Car c) { return update(c); }
	 */

	public int update(int id, String transmission, String enginetype, int horsepower, int torque,
			int numberofforwardgears, String driveline, String make, boolean hybrid, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType) {

		int executed = getEntityManager().createQuery(
				"UPDATE Car c set c.transmission.id = :transmission, c.enginetype = :enginetype, c.horsepower = :horsepower, c.torque = :torque, c.numberofforwardgears = :numberofforwardgears, c.driveline.id = :driveline, c.make = :make, c.hybrid = :hybrid, c.modelyear = :modelyear, c.name = :name, c.classification.id = :classification, c.year = :year, c.width = :width, c.length = :length, c.height = :height, c.highwaympg = :highwaympg, c.citymph = :citymph, c.fueltype.id = :fueltype WHERE c.id = :id")
				.setParameter("id", id).setParameter("transmission", Integer.valueOf(transmission))
				.setParameter("enginetype", enginetype).setParameter("horsepower", horsepower)
				.setParameter("torque", torque).setParameter("numberofforwardgears", numberofforwardgears)
				.setParameter("driveline", Integer.valueOf(driveline)).setParameter("make", make).setParameter("hybrid", hybrid)
				.setParameter("modelyear", modelyear).setParameter("name", name)
				.setParameter("classification", Integer.valueOf(classification)).setParameter("year", year)
				.setParameter("width", width).setParameter("length", length).setParameter("height", height)
				.setParameter("highwaympg", highwaympg).setParameter("citymph", citymph)
				.setParameter("fueltype", Integer.valueOf(fuelType)).executeUpdate();

		return executed;
	}

	public int insert(int id, String transmission, String enginetype, int horsepower, int torque,
			int numberofforwardgears, int pk, String driveline, String make, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType) {

		int executed = getEntityManager().createQuery(
				"INSERT INTO Car(id, citymph, enginetype, height, highwaympg, horsepower, length, make, modelyear, name, numberofforwardgears, pk, torque, width, year, classification, driveline, fueltype, transmission) "+"SELECT c.id, c.citymph, c.enginetype, c.height, c.highwaympg, c.horsepower,  c.length, c.make, c.modelyear, c.name, c.numberofforwardgears, c.pk, c.torque, c.year, c.width, c.classification, c.driveline, c.fueltype, c.transmission FROM Car c ")
				.setParameter("id", id).setParameter("transmission", Integer.valueOf(transmission))
				.setParameter("enginetype", enginetype).setParameter("horsepower", horsepower)
				.setParameter("torque", torque).setParameter("numberofforwardgears", numberofforwardgears)
				.setParameter("pk", pk)
				.setParameter("driveline", Integer.valueOf(driveline)).setParameter("make", make)
				.setParameter("modelyear", modelyear).setParameter("name", name)
				.setParameter("classification", Integer.valueOf(classification)).setParameter("year", year)
				.setParameter("width", width).setParameter("length", length).setParameter("height", height)
				.setParameter("highwaympg", highwaympg).setParameter("citymph", citymph)
				.setParameter("fueltype", Integer.valueOf(fuelType)).executeUpdate();

		return executed;
	}

	public int delete(int id) {

		int executed = getEntityManager().createQuery("DELETE FROM Car c WHERE c.id = :id").setParameter("id", id)
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