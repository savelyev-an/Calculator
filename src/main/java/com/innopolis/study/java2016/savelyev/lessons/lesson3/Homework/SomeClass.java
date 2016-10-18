package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.Homework;

public abstract  class SomeClass implements Runnable{
	public static Object lock = new Object();
	public void lock2() {
		synchronized (lock) {
			try {
				lock.wait();
				System.out.print("1");
			} catch (InterruptedException e) {}
		}
	}
	public void notifyThread() {
		synchronized (lock) {
			lock.notify();
		}
	}
	public void unlock1() {
		synchronized (lock) {
			lock.notify();
			System.out.print("2");
		}
	}
	public static void main(String s[]) {
		final SomeClass c = new SomeClass() {
			public void run() {
				lock2();
				notifyThread();
			}
		};
		final SomeClass c1 = new SomeClass() {
			public void run() {
				unlock1();
			Object a;
			}
		};
		Object o="aaaa";
		new Thread(c).start();
		new Thread(c1).start();
		try {
			System.out.println(Class.forName("java.lang.Integer"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

