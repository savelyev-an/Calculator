package com.innopolis.study.java2016.savelyev.test.lessons.lesson5.Syncro1;

/**
 * Created by User on 07.10.2016.
 */
public class Chrono extends Thread{
	private MyInt seconds;

	Chrono (MyInt seconds){
		this.seconds=seconds;
	}

	public void run () {

		while (!isInterrupted()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (seconds) {
				seconds.setValue(seconds.getValue() + 1);
				System.out.println("Время = " + seconds.getValue());
				seconds.notifyAll();
			}
		}}
}