package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternDelegate;

/**
 * Created by User on 25.10.2016.
 */
public class MultyClass implements First, Second {
	private First firstDelegate;
	private Second secondDelegate;

	public MultyClass(First firstDelegate, Second secondDelegate) {
		this.firstDelegate = firstDelegate;
		this.secondDelegate = secondDelegate;
	}

	public MultyClass() {
		this.firstDelegate = new FirstClass();
		this.secondDelegate = new SecondClass();
	}


	@Override
	public String firstFunction() {
		return firstDelegate.firstFunction();
	}

	@Override
	public String secondFunction() {
		return secondDelegate.secondFunction();
	}
}
