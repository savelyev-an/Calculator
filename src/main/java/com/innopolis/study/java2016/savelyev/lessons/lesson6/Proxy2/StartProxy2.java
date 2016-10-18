package com.innopolis.study.java2016.savelyev.lessons.lesson6.Proxy2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ТАК ДЕЛАЮТ ЛОГГИРОВАНИЕ !!!!!!!!!!!!!!!!
 */
public class StartProxy2 {
	public static void main(String[] args) {
		ClassLoader classLoader = StartProxy2.class.getClassLoader();
		InvocationHandler invocationHandler = new InvocationHandler() {
			Human human = new HumanImpl();

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("Аргумент ! ="+args[0].toString());

				System.out.println(" Отработал 1-й прокси " + method.getName());
				Object result = method.invoke(human, args); //- для void метода - result=null
				if (result == null)
					System.out.println(result);
				return result;
			}
		};
		Human human = (Human) Proxy.newProxyInstance(classLoader, new Class[]{Human.class}, invocationHandler);
		human.setAge(18);
		human.setName("John");
		System.out.println(human.getName(12));

		Human human2 =createHuman();
		human2.setName("saaa");
		human2.setAge(123);
		System.out.println(human2.getName(12));
	}



		static Human createHuman (){
			ClassLoader classLoader2 = StartProxy2.class.getClassLoader();
			InvocationHandler invocationHandler2 = new InvocationHandler() {
				Human human = new HumanImpl();
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println( " Отработал 2-й прокси "+ method.getName());
					Object result = method.invoke (human, args); //- для void метода - result=null

					if (result==null)
						System.out.println(result);
					return result;
				}
			};
			return (Human) Proxy.newProxyInstance(classLoader2, new Class [] {Human.class}, invocationHandler2);
		}
}
