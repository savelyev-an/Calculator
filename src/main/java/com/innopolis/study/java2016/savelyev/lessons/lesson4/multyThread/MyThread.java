package com.innopolis.study.java2016.savelyev.test.lessons.lesson4.multyThread;

public class MyThread extends Thread {
	private final String name;
	private Box counter ;

	public MyThread(String name, Box counter) {
		this.name = name;
		this.counter = counter;
//		setDaemon(true);

	}

	@Override
	public void run() {

//		if ("Thread1".equals(this.name))
//			throw new RuntimeException();
		for (int i=0 ; i <10; i++) {
			int count;
			synchronized (this.counter) {
				count = this.counter.getValue();
				this.counter.setValue(count + 1);
			}
			System.out.println(this.name+ " local counter ="+i+  " main counter = "+ count);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
