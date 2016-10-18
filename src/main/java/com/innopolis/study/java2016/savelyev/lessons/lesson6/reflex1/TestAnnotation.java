package com.innopolis.study.java2016.savelyev.lessons.lesson6.reflex1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by User on 10.10.2016.
 */


@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
 @interface StartObject {
}

@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface StopObject {
}

@Target(value=ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
@interface ControlledObject {
	String name();
}

@ControlledObject(name="biscuits")
public class TestAnnotation {

	@StartObject
	public void createCookie(){
		//бизнес логика
	}
	@StopObject
	public void stopCookie(){
		//бизнес логика
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Class cl = Class.forName("com.innopolis.study.java2016.savelyev.lessons.lesson6.reflex1.TestAnnotation");
		if(!cl.isAnnotationPresent(ControlledObject.class)){
			System.err.println("no annotation");
		} else {
			System.out.println("class annotated ; name  -  " + cl.getAnnotation(ControlledObject.class));
		}
		boolean hasStart=false;
		boolean hasStop=false;
		Method[] method = cl.getMethods();
		for(Method md: method){
			System.out.println(md.getName());
			if(md.isAnnotationPresent(StartObject.class)) {hasStart=true;}
			if(md.isAnnotationPresent(StopObject.class)) {hasStop=true;}
			if(hasStart && hasStop){break;}
		}
		System.out.println("Start annotaton  - " + hasStart + ";  Stop annotation  - " + hasStop );
	}
}
