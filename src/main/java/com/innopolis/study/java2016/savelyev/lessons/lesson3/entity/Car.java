package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.entity;

/**
 * Created by User on 05.10.2016.
 */
import java.io.Serializable;

public class Car implements Serializable{

	private String model;
	/*transient*/ private String regNum;

	public Car(String model, String regNum) {
		this.model = model;
		this.regNum = regNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Car car = (Car) o;

		return model.equals(car.model);

	}

	@Override
	public int hashCode() {
		return model.hashCode();
	}

	/**
	 * This method Returns the model
	 * @return
	 */

	public String getModel() {
		return model;
	}

	/**
	 * This method set model
	 * @param model -
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
}
