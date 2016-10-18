package com.innopolis.study.java2016.savelyev.lessons.lesson9.jUnit_1;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by masterlomaster on 12.10.16.
 */
public class HelloWorld {
	private static final String HELLO_WORLD= "HelloWorld";
	private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	public static void main(String[] args) {
		HelloWorld h=new HelloWorld();

		System.out.println(h.isHelloWorld("HelloWorld"));
	}


	public boolean isHelloWorld(String arg) {
		boolean result = false;
		if(arg!=null) {
			result = arg.toLowerCase().equals (HELLO_WORLD.toLowerCase());
		}
		return result;
	}

	public boolean isString(Object arg) {
		boolean result = false;
		if(arg!=null) {
			result = arg.getClass().equals (String.class);
		}
		return result;
	}


}