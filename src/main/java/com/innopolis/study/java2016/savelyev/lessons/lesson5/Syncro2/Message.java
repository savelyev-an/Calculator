package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro2;
/**
 * Поток - пишуший 5 секунд
 */
public class Message extends Thread {
	private MyInt timer;
	private int period;
	private  int prevTimer;

	Message (MyInt timer, int period){
		this.period=period;
		this.timer=timer;
	}

	public void run () {

		while (!isInterrupted()) {
			synchronized (this) {
				if ((timer.getValue()%period==0) && (timer.getValue()!=0) ) {
					System.out.println("Прошло "+period + "секунд! ");
					prevTimer=timer.getValue();
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				try {
					while (prevTimer==timer.getValue()){
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getPeriod() {
		return period;
	}
}
