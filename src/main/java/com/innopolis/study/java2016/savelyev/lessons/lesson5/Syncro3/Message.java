package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro3;

/**
 * Created by User on 08.10.2016.
 */
public class Message extends Thread {
	public volatile Boolean  isAwaken=false;
	protected int period;
	private String message;
	private MutableInteger counter;

	public Message(int period, String message, MutableInteger counter) {
		this.period =period;
		this.message = message;
		this.counter =counter;
		//synchronized (this) {waitingAwaking();}
	}

	public void doSome () {
		System.out.println(message+counter.getValue());
	}

	public void run() {
		System.out.println("Поток "+this + "Стартовал !");
		while (!isInterrupted()) {
			synchronized (this) {
				if (isAwaken)
				System.out.println(message+counter.getValue());
				isAwaken = false;
				while (!this.isAwaken) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public int getPeriod() {
		return period;
	}
}
