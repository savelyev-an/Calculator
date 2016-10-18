package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.Homework;

/**
 * Created by User on 05.10.2016.
 */
public class ThreadTest implements Runnable {
	private static ThreadTest
			shared = new ThreadTest();
	public Integer iiii;

	public void run() {
		synchronized (iiii) {
			for (int i = 0; i < 3; i++) {
				System.out.println(
						Thread.currentThread().
								getName() + " " + i);
				Thread.yield();
			}
		}
	}
	public static void main(String s[]) {
		for (int i=0; i<3; i++) {
			new Thread(new ThreadTest(),
					"Thread-"+i).start();
		}

		System.out.println("Проба wait");

		ThreadTest2 w1 = new ThreadTest2(1);
		new Thread(w1).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
		ThreadTest2 w2 = new ThreadTest2(2);
		new Thread(w2).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
		ThreadTest2 w3 = new ThreadTest2(3);
		new Thread(w3).start();
	}
}

class ThreadTest2 implements Runnable {
	final static private Object shared=new Object();
	private int type;
	public ThreadTest2(int i) {
		type=i;
	}

	public void run() {
		if (type==1 || type==2) {
			synchronized (shared) {
				try {
					shared.wait();
				} catch (InterruptedException e) {}
				System.out.println("Thread "+type+" after wait()");
			}
		} else {
			synchronized (shared) {
				shared.notifyAll();
				System.out.println("Thread "+type+" after notifyAll()");
			}
		}
	}


}