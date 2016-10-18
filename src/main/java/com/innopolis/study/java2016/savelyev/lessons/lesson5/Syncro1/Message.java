package com.innopolis.study.java2016.savelyev.test.lessons.lesson5.Syncro1;

/**
 * Поток - пишуший 5 секунд
 */
public class Message extends Thread {
	private MyInt seconds;
	private int period;
	private  int prevTimer;

	Message (MyInt seconds, int period){
		this.period=period;
		this.seconds=seconds;
	}

	public void run () {

		while (!isInterrupted()) {
			synchronized (seconds) {
				if ((seconds.getValue()%period==0) && (seconds.getValue()!=0) ) {
					System.out.println("Прошло "+period + "секунд! ");
					prevTimer=seconds.getValue();
				}

				try {
					while (prevTimer==seconds.getValue()){
						seconds.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}}
}
