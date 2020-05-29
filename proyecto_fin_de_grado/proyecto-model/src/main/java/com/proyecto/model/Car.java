
package com.proyecto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CAR")
public class Car implements Comparable<Car>, Serializable {

	private int pk;

	private static final long serialVersionUID = 3594839582111552527L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Engine Information
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "TRANSMISSION_ID", referencedColumnName = "ID")
	private Transmission transmission;

	@NotNull
	@Column(name = "ENGINETYPE", nullable = false)
	private String enginetype;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "DRIVELINE_ID", referencedColumnName = "ID")
	private DriveLine driveline;

	// @NotNull
	// @Column(name = "HYBRID", nullable = false) ///////// CAMBIADO
	// private Boolean hybrid;

	@NotNull
	@Column(name = "NUMBEROFFORWARDGEARS", nullable = false) ///////// CAMBIADO
	private int numberofforwardgears;

	@NotNull
	@Column(name = "HORSEPOWER", nullable = false) ///////// CAMBIADO
	private int horsepower;

	@NotNull
	@Column(name = "TORQUE", nullable = false) ///////// CAMBIADO
	private int torque;

	// Dimensions
	/*
	 * @NotNull
	 * 
	 * @Column(name = "DIMENSIONNAME", nullable = false) /////////// NUEVO private
	 * String dimensionname;
	 */

	@NotNull
	@Column(name = "WIDTH", nullable = false)
	private int width;

	@NotNull
	@Column(name = "LENGTH", nullable = false)
	private int length;

	@NotNull
	@Column(name = "HEIGHT", nullable = false)
	private int height;

	// Fuel

	@NotNull
	@Column(name = "CITYMPH", nullable = false)
	private int citymph;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "FUELTYPE_ID", referencedColumnName = "ID")
	private Fuel fueltype;

	@NotNull
	@Column(name = "HIGHWAYMPG", nullable = false)
	private int highwaympg;

	// Region

	/*
	 * @NotNull
	 * 
	 * @Column(name = "REGIONNAME", nullable = false) /////////// NUEVO private
	 * String regionname;
	 * 
	 * @NotNull
	 * 
	 * @Column(name = "PRICE", nullable = false) private int price;
	 */

	// Car

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "CLASSIFICATION_ID", referencedColumnName = "ID")
	private Classification classification;

	// @NotNull
	// @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade =
	// CascadeType.MERGE)
	// @JoinColumn(name = "MAKE_ID", referencedColumnName = "ID")
	// private Make make;

	@NotEmpty
	@Column(name = "MAKE", nullable = false)
	private String make;

	@NotNull
	@Column(name = "HYBRID", nullable = false)
	private boolean hybrid;

	@NotEmpty
	@Column(name = "MODELYEAR", nullable = false)
	private String modelyear;

	@NotEmpty
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull
	@Column(name = "YEAR", nullable = false)
	private int year;

	/*
	 * @NotNull
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	 * 
	 * @JoinColumn(name = "car_id") private List<CarImage> carImages;
	 */

	public Car() {

	}

	public Car(int pk, int id, Transmission transmission, String enginetype, DriveLine driveline,
			int numberofforwardgears, int horsepower, int torque, int width, int length, int height, int citymph,
			Fuel fueltype, int highwaympg, Classification classification, String make, boolean hybrid, String modelyear,
			String name, int year) {
		super();
		this.pk = pk;
		this.id = id;
		this.transmission = transmission;
		this.enginetype = enginetype;
		this.driveline = driveline;
		this.numberofforwardgears = numberofforwardgears;
		this.horsepower = horsepower;
		this.torque = torque;
		this.width = width;
		this.length = length;
		this.height = height;
		this.citymph = citymph;
		this.fueltype = fueltype;
		this.highwaympg = highwaympg;
		this.classification = classification;
		this.make = make;
		this.hybrid = hybrid;
		this.modelyear = modelyear;
		this.name = name;
		this.year = year;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public String getEnginetype() {
		return enginetype;
	}

	public void setEnginetype(String enginetype) {
		this.enginetype = enginetype;
	}

	public DriveLine getDriveline() {
		return driveline;
	}

	public void setDriveline(DriveLine driveline) {
		this.driveline = driveline;
	}

	public int getNumberofforwardgears() {
		return numberofforwardgears;
	}

	public void setNumberofforwardgears(int numberofforwardgears) {
		this.numberofforwardgears = numberofforwardgears;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCitymph() {
		return citymph;
	}

	public void setCitymph(int citymph) {
		this.citymph = citymph;
	}

	public Fuel getFueltype() {
		return fueltype;
	}

	public void setFueltype(Fuel fueltype) {
		this.fueltype = fueltype;
	}

	public int getHighwaympg() {
		return highwaympg;
	}

	public void setHighwaympg(int highwaympg) {
		this.highwaympg = highwaympg;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public boolean isHybrid() {
		return hybrid;
	}

	public void setHybrid(boolean hybrid) {
		this.hybrid = hybrid;
	}

	public String getModelyear() {
		return modelyear;
	}

	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int compareTo(Car o) {

		if (this.getId() <= o.getId()) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		Car c1 = (Car) obj;
		return this.getId() == c1.getId();
	}

	@Override
	public String toString() {
		return "Car [pk=" + pk + ", id=" + id + ", transmission=" + transmission + ", enginetype=" + enginetype
				+ ", driveline=" + driveline + ", numberofforwardgears=" + numberofforwardgears + ", horsepower="
				+ horsepower + ", torque=" + torque + ", width=" + width + ", length=" + length + ", height=" + height
				+ ", citymph=" + citymph + ", fueltype=" + fueltype + ", highwaympg=" + highwaympg + ", classification="
				+ classification + ", make=" + make + ", hybrid=" + hybrid + ", modelyear=" + modelyear + ", name="
				+ name + ", year=" + year + "]";
	}

}
