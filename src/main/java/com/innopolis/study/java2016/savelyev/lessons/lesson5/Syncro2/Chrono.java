package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro2;

/**
 * Created by User on 07.10.2016.
 */
public class Chrono extends Thread{
	private MyInt timer;

	Chrono (MyInt timer){
		this.timer=timer;
	}

	public void run () {

		while (!isInterrupted()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (timer) {
				timer.setValue(timer.getValue() + 1);
				System.out.println("Время = " + timer.getValue());
				timer.notifyAll(); //- теперь будит Dispetcher, но будить нужно и диспетчер
			}
		}}
}