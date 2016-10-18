package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro3;

/**
 * Created by User on 08.10.2016.
 */
public class ThreadWithIsAwakenControl extends Thread{
	public volatile Boolean  isAwaken=false;
	protected int period;

	ThreadWithIsAwakenControl() {
		//synchronized (this) {waitingAwaking();}
	}

	ThreadWithIsAwakenControl (int period){
		this.period = period;
		//synchronized (this) {waitingAwaking();}
	}

	public void run() {
		while (!isInterrupted()) {
			synchronized (this) {
				if (isAwaken) doSome();
				isAwaken = false;
				waitingAwaking ();
			}
		}
	}
	
	protected void waitingAwaking(){
		while (!this.isAwaken) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	
	public void doSome() {
		System.out.println("Переопределите метод doSome");
	}


	public int getPeriod() {
		return period;
	}

	public void wake () {
		isAwaken=true;
		//synchronized (this) {this.notify();}
	}
}
