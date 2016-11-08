package com.innopolis.study.java2016.savelyev.lessons.lesson13;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by User on 20.10.2016.
 */
@FunctionalInterface
public interface SampleFunctionalInterface {
	void doSome();
	//void doSome2(); // не можем сделать еще один абстрактный метод

	default void doSome2(){ // можем сделать  дефолтный метод
	};

	 static void doSomed3(){

	 }
}
