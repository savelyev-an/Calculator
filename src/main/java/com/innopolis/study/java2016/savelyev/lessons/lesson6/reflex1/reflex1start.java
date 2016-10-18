package com.innopolis.study.java2016.savelyev.lessons.lesson6.reflex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by User on 10.10.2016.
 */
public class reflex1start {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Class<TypeForTest> clazz= TypeForTest.class;
		System.out.println(clazz.getAnnotations());
		Field[] fields = clazz.getDeclaredFields();
		TypeForTest typeForText = clazz.newInstance();
		System.out.println("Конструкторы");
		for (Constructor constructor : clazz.getConstructors()) {
			System.out.println(constructor.getName());
			constructor.setAccessible(false);
		}
		System.out.println("поля");
		for (Field field : fields) {
			field.setAccessible(true);
			field.set (typeForText,10);
			System.out.println(field.getName() +" value "+ field.get(typeForText));
		}

		System.out.println(clazz);

		listFields (fields);



	}

	public static void listFields(Field[] fields) {
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
}
