package com.innopolis.study.java2016.savelyev.lessons.lesson13;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by User on 20.10.2016.
 */
public class SampleReferenceForMethods {
	public static void main(String[] args) {
		int value=0;
		value=1;

		List<String> list = new ArrayList<String>();
		list.add("aaaaaw");
		list.add("aa2aaaw");
		list.add("aaaa1aw");

		Test test = new Test();
		Collections.sort(list, test::doSome);

		for (String name : list) System.out.println(name);

		list.forEach((val)-> System.out.println(val)); // for each  - работает просит Consumer

		System.out.println("Отсортируем в обратную сторону");
		Collections.sort(list, (a,b)->test.doSome (b,a));
		list.forEach((val)-> System.out.println(val)); // for each  - работает просит Consumer

	}


}

class Test {
	public int doSome(String s1, String s2) {
		return s1.compareTo(s2);
	}
}