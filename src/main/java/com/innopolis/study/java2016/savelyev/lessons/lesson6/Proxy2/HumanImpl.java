package com.innopolis.study.java2016.savelyev.lessons.lesson6.Proxy2;

/**
 * Created by User on 10.10.2016.
 */
public class HumanImpl implements Human {
	private int age;
	private String name;

	@Override
	public int getAge(int n) {
		System.out.println("Get AGe !!!!!!!!!!!!!");
		return age;
	}

	@Override
	public void setAge(int age) {

		System.out.println("Set Age!!!!!!!!!!!");
		this.age = age;
	}

	@Override
	public String getName(int n) {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
