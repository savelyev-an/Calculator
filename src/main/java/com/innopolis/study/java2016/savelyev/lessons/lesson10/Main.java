package com.innopolis.study.java2016.savelyev.lessons.lesson10;

import org.slf4j.LoggerFactory;

/**
 * Created by User on 17.10.2016.
 */
public class Main {
	private static org.slf4j.Logger logger= LoggerFactory.getLogger(ClassLoader1.class);
//	LoggableClassLoader classLoader= new LoggableClassLoader(ClassLoader.getSystemClassLoader());

	public static void main(String[] args) throws ClassNotFoundException {
//		LoggableClassLoader classLoader = new LoggableClassLoader(Main.class.getClassLoader());
		LoggableClassLoader classLoader2 = new LoggableClassLoader(Main.getClassLoader());
		System.out.println("Не просто так");

		Class test = classLoader2.loadClass("DDD");
	}


	private static ClassLoader getClassLoader () {
		return Main.class.getClassLoader();
	}
}
