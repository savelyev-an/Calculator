package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.resourse;

/**
 * Created by User on 05.10.2016.
 */
public class DBResourse implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close DB" );
		throw new RuntimeException();
	}
}
