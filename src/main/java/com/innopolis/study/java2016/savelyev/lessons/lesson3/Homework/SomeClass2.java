package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.Homework;

import java.io.Serializable;

/**
 * Created by User on 05.10.2016.
 */
public abstract  class SomeClass2  implements Runnable {
	private Object lock = new Object();
	public void lock() {
		synchronized (lock) {
			try {
				System.out.print("1");
				lock.wait();
			} catch (InterruptedException e) {}
		}
	}
	public void unlock() {
		synchronized (lock) {
			lock.notify();
			System.out.print("2");
		}
	}
	public static void main(String s[]) {
		new Thread(new SomeClass2() {
			public void run() {
				lock();
			}
		}).start();
		new Thread(new SomeClass2() {
			public void run() {
				unlock();
			}
		}).start();
	}
}

