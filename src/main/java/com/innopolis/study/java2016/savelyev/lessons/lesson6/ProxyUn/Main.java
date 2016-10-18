package com.innopolis.study.java2016.savelyev.lessons.lesson6.ProxyUn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by User on 10.10.2016.
 */
public class Main implements DoSomeInterface{
	public void doSome() {
		System.out.println("Мвахахаха");
	}

	public static void main(String[] args) {
		DoSomeInterface a = (DoSomeInterface)createLoger(new Main());
		a.doSome();
	}


	static Object createLoger (Object old){
		ClassLoader classLoader = Main.class.getClassLoader();
		InvocationHandler invocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
				System.out.println( " Отработал прокси с таким методом "+ method.getName());
				Object result = method.invoke (old, args);
				return result;
			}
		};
		return (Object)Proxy.newProxyInstance(classLoader, old.getClass().getInterfaces(), invocationHandler);
	}
}
