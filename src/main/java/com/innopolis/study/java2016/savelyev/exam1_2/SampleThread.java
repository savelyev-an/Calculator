package com.innopolis.study.java2016.savelyev.exam1_2;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Created by User on 10.10.2016.
 */
public class SampleThread {
	public static void main(String[] args) {
		for (int i=1; i<10;i++) {
			Thread t = new MyThread("Поток "+i);
			t.start();
		}
	}
}

class MyThread extends Thread {
	public MyThread(String name) {
		this.name = name;
	}
    public String name;

	public void run() {
		while (!isInterrupted()) {
			System.out.println("Thread " + name + " i am alive !");
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}