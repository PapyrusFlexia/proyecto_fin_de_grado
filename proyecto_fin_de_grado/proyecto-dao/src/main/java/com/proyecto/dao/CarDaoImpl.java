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

	
	/** Función que controla la paginación
	 *
	 */
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

	/** Función que recoge los engranajes delanteros
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsNumberOfForwardGears() {

		List<Integer> listNumberOfForwardGears = getEntityManager()
				.createQuery("SELECT DISTINCT c.numberofforwardgears FROM Car c ORDER BY c.numberofforwardgears")
				.getResultList();

		return listNumberOfForwardGears;
	}

	/** Función que recoge los años
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsYears() { 

		List<Integer> listYears = getEntityManager().createQuery("SELECT DISTINCT c.year FROM Car c ORDER BY c.year")
				.getResultList();

		return listYears;
	}

	/** Función que recoge las marcas
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getCarsMakes() { 

		List<String> listMakes = getEntityManager().createQuery("SELECT DISTINCT c.make FROM Car c ORDER BY c.make")
				.getResultList();

		return listMakes;
	}

	/** Función que recoge los nombres
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getCarsNames() {

		List<String> listNames = getEntityManager().createQuery("SELECT c.name FROM Car c ORDER BY c.name")
				.getResultList();

		return listNames;
	}

	/** Función que recoge las marcas filtradas
	 *
	 */
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

	/** Función que recoge el id de los coches
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsId() {

		List<Integer> listId = getEntityManager().createQuery("SELECT DISTINCT c.id FROM Car c ORDER BY c.id")
				.getResultList();

		return listId;
	}

	/** Función que recoge cla clave prncipal de un coche
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsPk() {

		List<Integer> listPk = getEntityManager().createQuery("SELECT DISTINCT c.pk FROM Car c ORDER BY c.pk")
				.getResultList();

		return listPk;
	}

	/** Función que encuentra coches por id
	 * @param id
	 * @return
	 */
	public Car findCarById(int id) {

		try {
			Car c = (Car) getEntityManager().createQuery("SELECT c FROM Car c WHERE c.id = :id").setParameter("id", id)
					.getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}

	/** Función que encuentra coches por nombre
	 * @param name
	 * @return
	 */
	public Car findCarByName(String name) {

		try {
			Car c = (Car) getEntityManager().createQuery("SELECT c FROM Car c WHERE c.name = :name")
					.setParameter("name", name).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}

	/** Función que encuentra coches por año
	 *
	 */
	public List<Car> findYearByName(int name) {

		try {
			List<Car> year = (List<Car>) getEntityManager().createQuery("SELECT c FROM Car c where c.year = :year")
					.setParameter("year", name).getResultList();
			return year;
		} catch (NoResultException e) {
			return null;
		}
	}

	/** Función que encuentra coches por marca
	 *
	 */
	public List<Car> findMakeByName(String name) {

		try {
			List<Car> make = (List<Car>) getEntityManager().createQuery("SELECT c FROM Car c where c.make = :make")
					.setParameter("make", name).getResultList();
			return make;
		} catch (NoResultException e) {
			return null;
		}
	}

	/** Función que encuentra coches por híbrido y los ordena por híbrido
	 *
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Boolean> getCarsHybrids() {

		List<Boolean> listCarsHybrids = getEntityManager()
				.createQuery("SELECT DISTINCT c.hybrid FROM Car c ORDER BY c.hybrid").getResultList();

		return listCarsHybrids;
	}

	/** Función que encuentra coches por híbrido
	 *
	 */
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

	/** Función que encuentra coches por clasificación
	 *
	 */
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

	/** Función que encuentra todos los coches
	 *
	 */
	@Override
	public long totalCar() {
		long totalCar = (long) getEntityManager().createQuery("SELECT COUNT (c.id) FROM Car c").getSingleResult();
		return totalCar;
	}


	/** Función que busca coches por nombre y los guarda
	 *
	 */
	@Override
	public Car save(Car c) {
		Car c1 = findCarByName(c.getName());
		if (c1 == null) {
			persist(c);
		}
		return c1;
	}

	/** Función que busca todos los coches
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<Car> findAllCars() {
		List<Car> cars = getEntityManager().createQuery("SELECT c FROM Car c ORDER BY c.id ASC").getResultList();
		return cars;
	}

	/** Función que elimina coches por id
	 *
	 */
	public void deleteById(String id) {
		Car car = (Car) getEntityManager().createQuery("SELECT c FROM Car c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		delete(car);
	}

	

	/** Función que actualiza los coches
	 *
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
				.setParameter("driveline", Integer.valueOf(driveline)).setParameter("make", make)
				.setParameter("hybrid", hybrid).setParameter("modelyear", modelyear).setParameter("name", name)
				.setParameter("classification", Integer.valueOf(classification)).setParameter("year", year)
				.setParameter("width", width).setParameter("length", length).setParameter("height", height)
				.setParameter("highwaympg", highwaympg).setParameter("citymph", citymph)
				.setParameter("fueltype", Integer.valueOf(fuelType)).executeUpdate();

		return executed;
	}

	/** Función que inserta los coches
	 *
	 */
	public int insert(int id, String transmission, String enginetype, int horsepower, int torque,
			int numberofforwardgears, int pk, String driveline, String make, String modelyear, String name,
			String classification, int year, int width, int length, int height, int highwaympg, int citymph,
			String fuelType) {

		int executed = getEntityManager().createQuery(
				"INSERT INTO Car(id, citymph, enginetype, height, highwaympg, horsepower, length, make, modelyear, name, numberofforwardgears, pk, torque, width, year, classification, driveline, fueltype, transmission) "
						+ "SELECT c.id, c.citymph, c.enginetype, c.height, c.highwaympg, c.horsepower,  c.length, c.make, c.modelyear, c.name, c.numberofforwardgears, c.pk, c.torque, c.year, c.width, c.classification, c.driveline, c.fueltype, c.transmission FROM Car c ")
				.setParameter("id", id).setParameter("transmission", Integer.valueOf(transmission))
				.setParameter("enginetype", enginetype).setParameter("horsepower", horsepower)
				.setParameter("torque", torque).setParameter("numberofforwardgears", numberofforwardgears)
				.setParameter("pk", pk).setParameter("driveline", Integer.valueOf(driveline)).setParameter("make", make)
				.setParameter("modelyear", modelyear).setParameter("name", name)
				.setParameter("classification", Integer.valueOf(classification)).setParameter("year", year)
				.setParameter("width", width).setParameter("length", length).setParameter("height", height)
				.setParameter("highwaympg", highwaympg).setParameter("citymph", citymph)
				.setParameter("fueltype", Integer.valueOf(fuelType)).executeUpdate();

		return executed;
	}

	/** Función que elimina coches por id
	 *
	 */
	public int delete(int id) {

		int executed = getEntityManager().createQuery("DELETE FROM Car c WHERE c.id = :id").setParameter("id", id)
				.executeUpdate();

		return executed;
	}


	/** Función que recoge la clave principal de un coche
	 *
	 */
	public Car getByPk(Integer key) {
		return getByKey(key);
	}

}