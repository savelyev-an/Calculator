package com.innopolis.study.java2016.savelyev.lessons.lesson6.reflex1;

import javax.xml.ws.soap.Addressing;

/**
 * Created by User on 10.10.2016.
 */
@TypeForAnnotation
public class TypeForTest {
	@Addressing
	final private int privateField=5;
	protected int protectedField;
	public int publicField;
}
