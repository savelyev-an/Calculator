package com.innopolis.study.java2016.savelyev.lessons.lesson6.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by User on 10.10.2016.
 */
public class StartProxy3 {
	public static void main(String[] args) {
		Human pureHuman = getHuman ();
		Human humanProxy = createHuman();
		Human delegateHuman = new HumanDelegate();

		long timestemp = System.currentTimeMillis();
		for (int i=0; i< 10_000; i++) {
			humanProxy.setAge((int)Math.random()*100);
		}
		System.out.println("System invoked for " + (System.currentTimeMillis()-timestemp));
		timestemp = System.currentTimeMillis();
		for (int i=0; i< 10_000; i++) {
			pureHuman.setAge((int)Math.random()*100);
		}
		System.out.println("System invoked for " + (System.currentTimeMillis()-timestemp));
		timestemp = System.currentTimeMillis();
		for (int i=0; i< 10_000; i++) {
			delegateHuman.setAge((int)Math.random()*100);
		}
		System.out.println("System invoked for " + (System.currentTimeMillis()-timestemp));

	}

	static Human getHuman() {
		return new HumanImpl();
	}

	static Human createHuman (){
		ClassLoader classLoader2 = StartProxy3.class.getClassLoader();
		InvocationHandler invocationHandler2 = new InvocationHandler() {
			Human human = new HumanImpl();
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				System.out.println( " Отработал 2-й прокси "+ method.getName());
				Object result = method.invoke (human, args); //- для void метода - result=null
//				if (result==null)
//					System.out.println(result);
				return result;
			}
		};
		return (Human) Proxy.newProxyInstance(classLoader2, new Class [] {Human.class}, invocationHandler2);
	}
}
