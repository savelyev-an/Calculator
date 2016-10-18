package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro2;

import java.util.HashSet;
import java.util.Set;

/**
 * Совместная работа 2-потоков
 */

public class StartPoint {



	public static void main(String[] args) {
		System.out.println("Start! ");
		MyInt  timer = new MyInt();
		Chrono myChrono = new Chrono (timer);
		myChrono.start();
		System.out.println("Finish!");

		Set<Message> mySet = new HashSet<>();
		mySet.add(new Message(timer,5));
		mySet.add (new Message(timer,7));
		mySet.add (new Message(timer,8));

		Dispetcher dispetcher = new Dispetcher (mySet, timer);
		for (Message message : mySet) {message.start();}
		dispetcher.start();
	}
}

