package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro3;

import com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro2.*;

import java.util.Set;
//import ThreadWithIsAwakenControl.*;

public class Dispetcher extends ThreadWithIsAwakenControl {
	private MutableInteger counter;
	private Set<Message> setOfThreads;
	private int prevCounter;

	public Dispetcher(MutableInteger counter, Set<Message> setOfThreads) {
		this.counter = counter;
		this.setOfThreads = setOfThreads;
		prevCounter = this.counter.getValue();
		System.out.println("Зашли в конструктор диспетчера!");
		//waitingAwaking();
	}

	//@Override
	public void run1() {
		while (!isInterrupted()) {
			//System.out.println("зашли в doSome диспетчера! - его должны будить каждую секунду!");
			for (Message thisThread : setOfThreads) {
				;
				if (counter.getValue() % thisThread.getPeriod() == 0) {
					synchronized (thisThread) {
						thisThread.isAwaken = true;
						thisThread.notify();
					}
				}
			}
			prevCounter = this.counter.getValue();
			waitingAwaking();
		}
	}

	protected void waitingAwaking() {
		synchronized (counter) {
			while (this.prevCounter == this.counter.getValue()) {
				try {
					counter.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void run() {
		while (!isInterrupted()) {
			System.out.println("Диспа разбудили, думает...");
			for (Message thisThread : setOfThreads) {
				int curTime = counter.getValue();
//				System.out.println("curTime= "+curTime+ "   thisThread.getPeriod()= "+thisThread.getPeriod()+ " Notify ? "+ (curTime % thisThread.getPeriod() == 0 && curTime != 0));
				if (curTime % thisThread.getPeriod() == 0 && curTime != 0)
					synchronized (thisThread) {
						System.out.println("Будим ->" + thisThread);
						thisThread.isAwaken=true;
						thisThread.notify();

					}
			}
			prevCounter = counter.getValue();

			synchronized (counter) {
				try {
					while (prevCounter == counter.getValue()) {
						System.out.println("Дисп засыпает");
						counter.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
