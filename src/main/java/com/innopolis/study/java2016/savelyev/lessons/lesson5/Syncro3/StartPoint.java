package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro3;

import java.util.HashSet;
import java.util.Set;

/**
 * Совместная работа 2-потоков
 */

public class StartPoint {
	static volatile MutableInteger  timer_value;
	public static void main(String[] args) {
		System.out.println("Start! ");
		timer_value = new MutableInteger (0);
		Timer timer = new Timer (timer_value, 1000);
		timer.start();
		System.out.println("timer is starting2!");

		Set<Message> mySet = new HashSet<>();
		mySet.add(new Message(5, "Прошло секунд ->", timer_value));
		mySet.add (new Message(7, "А эта надпись появляется раз в 7 секунд!", timer_value));
		mySet.add (new Message(10, "10 секунд ХОП! ", timer_value));

		System.out.println("Хочу диспетчера!");
		Dispetcher dispetcher = new Dispetcher(timer_value, mySet);
		System.out.println("Диспетчера создали, стартуем всякую фигн");
		for (Message thisThread : mySet) {
			thisThread.start();}
		dispetcher.start();
	}
}

