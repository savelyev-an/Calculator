package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.resourse;

/**
 * Created by User on 05.10.2016.
 */
public class NetResourse implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println( "Close NET");
		throw new RuntimeException();
	}
}
