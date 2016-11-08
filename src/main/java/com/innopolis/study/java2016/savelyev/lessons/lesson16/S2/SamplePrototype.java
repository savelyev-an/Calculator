package com.innopolis.study.java2016.savelyev.lessons.lesson16.S2;

/**
 * Created by User on 25.10.2016.
 */
public class SamplePrototype {
	public static void main(String[] args) {
		Sample d1=new Sample();
		Replicator replicator =new Replicator();
		replicator.setPrototype(d1);
		Sample d2=replicator.copy();
		System.out.println(d1);
		System.out.println(d2);
	}
}

