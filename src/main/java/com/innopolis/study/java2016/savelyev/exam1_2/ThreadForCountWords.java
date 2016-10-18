package com.innopolis.study.java2016.savelyev.exam1_2;


import java.util.*;

/**
 * Метод выполняющий задачу импорта потока слов из заданных ресурсов и формирования частотного словаря
 */

public class ThreadForCountWords extends Thread{
	private Queue <String> queueResourses;
	private ConcurrentHashMapRate <String> mapWordsRate;
	BoxException globalException;

	// это конструктор для даунов
	public ThreadForCountWords(Queue<String> queueResourses, ConcurrentHashMapRate<String> mapWordsRate) {
		this.queueResourses = queueResourses;
		this.mapWordsRate = mapWordsRate;
		this.globalException = new BoxException();
		this.start();
	}

	public ThreadForCountWords(Queue<String> queueResourses, ConcurrentHashMapRate<String> mapWordsRate, BoxException globalException) {
		this.queueResourses = queueResourses;
		this.mapWordsRate = mapWordsRate;
		this.mapWordsRate.clear();
		this.globalException = globalException;
		this.start();
	}

	public void run() {
		Set<Thread> setOfThread = new HashSet<>();
		while (!queueResourses.isEmpty()) {
			String resourseName = queueResourses.remove();
			setOfThread.add(new ProceedingResourse(resourseName, mapWordsRate, globalException));
		}
		boolean isAliveThreads=true;
		while (isAliveThreads && !isInterrupted()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isAliveThreads = false;
			for (Thread thread : setOfThread)
				if (!thread.isInterrupted()) {
					isAliveThreads = false; break;
				}
		}
		if (globalException.getValue()!=null) {
			System.out.println("Обработка списка ресурсов прервана по причине ошибки, словарь очищен.");
			globalException.getValue().printStackTrace();
			mapWordsRate.clear();
		}
		System.out.println("проверочный вывод словаря:");
		mapWordsRate.list();
	}

	public static void main(String[] args) {
		ConcurrentHashMapRate <String> mapWordsRate= new ConcurrentHashMapRate<>();
		Queue <String> queueResourses= new LinkedList<>();
		BoxException globalException = new BoxException();

		queueResourses.add(".\\source2.txt");
		queueResourses.add(".\\source.txt");
//		queueResourses.add(".\\source1.txt");
		queueResourses.add(".\\source.xt");

		ThreadForCountWords t1=new ThreadForCountWords(queueResourses, mapWordsRate,globalException);
	}
}

class BoxException {
	private Exception globalException;


	public BoxException() {
		this.globalException = null;
	}

	public Exception getValue() {
		return globalException;
	}

	public void setValue(Exception globalException ) {
		this.globalException = globalException;
	}
}
