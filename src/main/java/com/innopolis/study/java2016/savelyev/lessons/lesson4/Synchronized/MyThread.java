package com.innopolis.study.java2016.savelyev.test.lessons.lesson4.Synchronized;

public class MyThread extends Thread {
	private final String name;
	private Box counter ;

	public MyThread(String name, Box counter) {
		this.name = name;
		this.counter = counter;
	}

	@Override
	public void run() {
		synchronized (this.counter) {
//			doSome(); // Возможна блокировка
			try {
				this.counter.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println( "Thread "+ this.name + " Succes !" );
	}
//	private doSome(){
//		synchronized (this.counter){
//
//		}
//	}
}
