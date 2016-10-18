package com.innopolis.study.java2016.savelyev.lessons.lesson6.proxy3;

/**
 * Created by User on 10.10.2016.
 */
public class HumanDelegate implements Human {
	private Human delegate2= new HumanImpl();

	public HumanDelegate() {
		}

	@Override
	public int getAge() {
		return delegate2.getAge();
	}

	@Override
	public void setAge(int age) {
		delegate2.setAge(age);
	}

	@Override
	public String getName() {

		return delegate2.getName();
	}

	@Override
	public void setName(String name) {
		delegate2.setName(name);
	}
}

