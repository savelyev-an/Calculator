package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro2;

import java.util.Set;

/**
 * Created by User on 07.10.2016.
 */
public class Dispetcher extends Thread{
	private Set<Message> processingSet;
	private MyInt timer;
	private  int prevTimer=0;

	public Dispetcher(Set<Message> processingSet, MyInt timer) {
		this.processingSet = processingSet;
		this.timer = timer;
	}

	public void run(){
		while (!isInterrupted()) {

			for (Message message : processingSet){
				int curTime=timer.getValue();
				if (curTime%message.getPeriod() ==0 && curTime!=0)
					synchronized ( message) {message.notify();}
			}
			prevTimer=timer.getValue();

			synchronized (timer) {
				try {
					while (prevTimer == timer.getValue()) {
						timer.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
