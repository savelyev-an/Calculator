package com.innopolis.study.java2016.savelyev.exam_1_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Пример  создания и запуска объекта класса ThreadForCountWords
 * Created by User on 12.10.2016.
 */
public class StartPointThreadFoCount {
	public static void main(String[] args) {
		ConcurrentHashMapRate<String> mapWordsRate= new ConcurrentHashMapRate<>();
		Queue<String> queueResourses= new LinkedList<>();
		ExceptionWraper globalException = new ExceptionWraper();

//		queueResourses.add(".\\source2.txt"); // сто русских строик
//		queueResourses.add(".\\source.txt"); // три русских строик
//		queueResourses.add(".\\source1.txt"); // 55 руских строк и одной латинской буквой в конце
//		queueResourses.add(".\\source.xt"); // несуществующее имя

		for (int i=0; i<args.length;i++)
			queueResourses.add(args[i]);

		ThreadForCountWords t1=new ThreadForCountWords(queueResourses, mapWordsRate,globalException);
		t1.start();
	}
}
