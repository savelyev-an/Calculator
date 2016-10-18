package com.innopolis.study.java2016.savelyev.lessons.lesson6.proxy3;

/**
 * Created by User on 10.10.2016.
 */
public class HumanImpl implements Human {
	private int age;
	private String name;

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
