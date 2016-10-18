package com.innopolis.study.java2016.savelyev.lessons.lesson6.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by User on 10.10.2016.
 */
public class StartProxy {
	public static void main(String[] args) {
		FirstInterface firstInterface= new FirstInterface() {
			@Override
			public int doSome(int n) {
				System.out.println(" 1- интерфейс work! " +n);
				return 10;
			}
		};
		System.out.println(firstInterface.doSome(12));

		FirstInterface proxy = (FirstInterface)Proxy.newProxyInstance(
			StartProxy.class.getClassLoader(),
			new Class[]{FirstInterface.class, SecondInterface.class}, // ТОлько Интерфейсы ! нельзя String.class
			new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						for (int i =0 ; i<args.length;i++) System.out.println("аргумент "+i+" ="+ args[i]);

					if ("doSome".equals (method.getName()))
						return 5;
					if ("doSomethingElse".equals (method.getName()))
						return "DDD";
					if ("doSomethingElse2".equals (method.getName()))
						return 100;
					else return -1;
				}
			});
		System.out.println("Интерфейс тип 1: ");
		System.out.println(((FirstInterface) proxy).doSome(20));
		System.out.println(((SecondInterface) proxy).doSomethingElse());
		System.out.println(((SecondInterface) proxy).doSomethingElse2());
	}
}
