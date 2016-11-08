package com.innopolis.study.java2016.savelyev.lessons.lesson13;



import java.util.*;

/**
 * Created by User on 20.10.2016.
 */
public class SampleLambda {
	public static void main(String[] args) {
		int value=0;
//		value=1;

		List<String> list = new ArrayList<String>();
		list.add("aaaaaw");
		list.add("aa2aaaw");
		list.add("aaaa1aw");

		Collections.sort(list, new Comparator <String>() {
			@Override
			public int compare(String o1, String o2) {
				int y =value;// value - final или effectivly final
//				this.reversed(); // можно обращаться к дефолтным реализациям интерфейса.
				return o1.compareTo(o2);
			}
		});

		// Можем подменить интрефейс только с одним АБСТРАКТНЫМ методом !!!!!!!!!!!!!!!!!!!!!
		Collections.sort(list, (String o1, String o2) -> {
			int y = value;
//			value=9; // value - final или effectivly final
			return o1.compareTo(o2);
		});


// Можно убрать типы данных

//		Collections.sort(list, (o1, o2) -> {
//			return o1.compareTo(o2);
//		});

// если простая функция - убираем return и {;}
//		Collections.sort(list, (o1, o2) ->
//			o1.compareTo(o2)
//		);




		for (String name : list) System.out.println(name);

		list.forEach((val)-> System.out.println(val)); // for each  - работает просит Consumer
	}


}
