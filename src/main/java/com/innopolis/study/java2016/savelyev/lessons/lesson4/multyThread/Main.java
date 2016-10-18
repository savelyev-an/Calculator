package com.innopolis.study.java2016.savelyev.test.lessons.lesson4.multyThread;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 06.10.2016.
 */
public class Main {
	public static void main(String[] args) {
		Set<Thread> threadSet = new HashSet<>();
		Box box = new Box(1);
		threadSet.add(new MyThread("Thread-1" , box));
		threadSet.add(new MyThread("Thread-2", box));
		threadSet.add(new MyThread("Thread-3", box));

		for (Thread thread : threadSet)
			thread.start();
		System.out.println("Main is finished");
//		System.out.println( "Finish Counter = " box.getValue());
	}
}
