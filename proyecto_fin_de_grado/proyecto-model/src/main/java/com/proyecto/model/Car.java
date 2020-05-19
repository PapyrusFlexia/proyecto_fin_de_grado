
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
	private Engine engine;
	private Dimensions dimensions;
	private Fuel fuel;

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

	@NotNull
	@Column(name = "HYBRID", nullable = false) ///////// CAMBIADO
	private Boolean hybrid;

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
	@NotNull
	@Column(name = "DIMENSIONNAME", nullable = false) /////////// NUEVO
	private String dimensionname;

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

	@NotNull
	@Column(name = "REGIONNAME", nullable = false) /////////// NUEVO
	private String regionname;

	@NotNull
	@Column(name = "PRICE", nullable = false)
	private int price;

	// Car

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "CLASSIFICATION_ID", referencedColumnName = "ID")
	private Classification classification;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "MAKE_ID", referencedColumnName = "ID")
	private Make make;

	@NotEmpty
	@Column(name = "MODELYEAR", nullable = false)
	private String modelyear;

	@NotEmpty
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull
	@Column(name = "YEAR", nullable = false)
	private int year;

	@NotNull
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "car_id")
	private List<CarImage> carImages;

	public Car() {
		
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
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

	public Boolean getHybrid() {
		return hybrid;
	}

	public void setHybrid(Boolean hybrid) {
		this.hybrid = hybrid;
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

	public String getDimensionname() {
		return dimensionname;
	}

	public void setDimensionname(String dimensionname) {
		this.dimensionname = dimensionname;
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

	public String getRegionname() {
		return regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
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

	public List<CarImage> getCarImages() {
		return carImages;
	}

	public void setCarImages(List<CarImage> carImages) {
		this.carImages = carImages;
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
		return "Car [pk=" + pk + ", engine=" + engine + ", dimensions=" + dimensions + ", fuel=" + fuel + ", id=" + id
				+ ", transmission=" + transmission + ", enginetype=" + enginetype + ", driveline=" + driveline
				+ ", hybrid=" + hybrid + ", numberofforwardgears=" + numberofforwardgears + ", horsepower=" + horsepower
				+ ", torque=" + torque + ", dimensionname=" + dimensionname + ", width=" + width + ", length=" + length
				+ ", height=" + height + ", citymph=" + citymph + ", fueltype=" + fueltype + ", highwaympg="
				+ highwaympg + ", regionname=" + regionname + ", price=" + price + ", classification=" + classification
				+ ", make=" + make + ", modelyear=" + modelyear + ", name=" + name + ", year=" + year + ", carImages="
				+ carImages + "]";
	}
	
	

}