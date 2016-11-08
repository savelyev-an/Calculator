package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePrototype;

/**
 * Created by User on 25.10.2016.
 */
public class Replicator extends Sample{
	private Sample prototype;


	public void setPrototype(Sample prototype) {
		this.prototype = prototype;
	}

	public Sample copy() {
		return this.prototype.clone();}

}
