package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.entity;

/**
 * Created by User on 05.10.2016.
 */
public class Order {
	private Customer customer;

/*
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		return customer != null ? customer.equals(order.customer) : order.customer == null;

	}

	@Override
	public int hashCode() {
		return customer != null ? customer.hashCode() : 0;
	}
*/

	public Order(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		customer = customer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		return customer.equals(order.customer);

	}

	@Override
	public int hashCode() {
		return customer.hashCode();
	}
}
