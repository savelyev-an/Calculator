package com.innopolis.study.java2016.savelyev.lessons.lesson10;

import org.slf4j.LoggerFactory;

/**
 * Created by User on 17.10.2016.
 */
public class LoggableClassLoader extends ClassLoader {
	private static org.slf4j.Logger logger= LoggerFactory.getLogger(ClassLoader1.class);
	LoggableClassLoader (ClassLoader parent) {
		super (parent);
	}

	@Override
	public Class<?> findClass (String name ) throws ClassNotFoundException {
		logger.info ("find class with name {}", name);
		return null; // getParent().findClass(name);

		/**
		 * find file
		 * load
		 */

	}

}

