package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.entity;

/**
 * Created by User on 05.10.2016.
 */
public class Customer {
	private final String name;
	private final String surname;
	private final int age;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		if (age != customer.age) return false;
		if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
		return surname != null ? surname.equals(customer.surname) : customer.surname == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + age;
		return result;
	}

	public Customer(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName() {
		return name;
	}
/*
	public void setName(String name) {
		this.name = name;
	}
*/
	public String getSurname() {
		return surname;
	}
/*
	public void setSurname(String surname) {
		this.surname = surname;
	}
*/
	public int getAge() {
		return age;
	}

/*	public void setAge(int age) {
		this.age = age;
	}
*/
}
