package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro3;

/**
 * Created by User on 08.10.2016.
 */
public class MutableInteger {
	private int value;

	public MutableInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
