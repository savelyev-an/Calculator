package com.innopolis.study.java2016.savelyev.test.lessons.lesson4.Synchronized;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * Created by User on 06.10.2016.
 */
public class Main {
	public static void main(String[] args) {
		Box box = new Box(1);

		Thread t1 = new MyThread ("Thread-1" , box);
		Thread t2 = new MyThread ("Thread-2" , box);
		Thread t3= new MyThread ("Thread-3" , box);
		Set<Thread> threadSet = new HashSet<>();
		threadSet.add(t1);
		threadSet.add(t2);
		threadSet.add(t3);


		for (Thread thread : threadSet)
			thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread is finished");
//		t1.interrupt(); //выбросит исключение

		synchronized (box) {
			box.notify();
		}

		System.out.println("Main thread is finished=- label 2");
//		System.out.println( "Finish Counter = " box.getValue());
	}
}
