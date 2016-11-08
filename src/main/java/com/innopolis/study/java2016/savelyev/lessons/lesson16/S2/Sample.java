package com.innopolis.study.java2016.savelyev.lessons.lesson16.S2;

/**
 * Created by User on 25.10.2016.
 */
class Sample implements Cloneable {
	private String name="Гайка";

	public String getName() {
		return name;
	}
	@Override
	public Sample clone()  {
		Sample result = null;
		try {
			result=  (Sample) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	return result ;}

	@Override
	public String toString (){return name;}
}
