package com.innopolis.study.java2016.savelyev.exam_1_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Метод-поток выполняющий задачу импорта потоков слов из заданных ресурсов и формирования частотного словаря
 * путем генерации потоков обработки в соответствии с
 * Поток run данного метода остается активным до окончания работы последнего потока обработки им порожденного.
 * В случае если потоки были прерваны из-за ошибки возникшей в одном из них, частотный словарь будет
 * возвращен пустым
 */

public class ThreadForCountWords extends Thread{
	private Queue <String> queueResourses;
	private ConcurrentHashMapRate<String> mapWordsRate;
	private ExceptionWraper globalException;
	private static Logger logger = LoggerFactory.getLogger(ThreadForCountWords.class);

	/**
	 * Конструктор генератора потоков обработки
	 * @param queueResourses - список входящих ресурсов
	 * @param mapWordsRate - ссылка на частотный словарь, куда надо помещять информацию
	 * @param globalException - ссылка на ExceptionWraper в которых сохраняется исключение порожденное потоком
	 *                        обнаружившим ошибку
	 */
	public ThreadForCountWords(Queue<String> queueResourses, ConcurrentHashMapRate<String> mapWordsRate, ExceptionWraper globalException) {
		this.queueResourses = queueResourses;
		this.mapWordsRate = mapWordsRate;
		this.mapWordsRate.clear();
		this.globalException = globalException;
	}
	/**
	 * Упрощенный конструктор генератора потоков обработки - вместо внешней ссылки на
	 * @param queueResourses
	 * @param mapWordsRate
	 */
	public ThreadForCountWords(Queue<String> queueResourses, ConcurrentHashMapRate<String> mapWordsRate) {
		this.queueResourses = queueResourses;
		this.mapWordsRate = mapWordsRate;
		this.globalException = new ExceptionWraper();
	}


	public void run() {
		ThreadGroup groupThreads = new ThreadGroup("Processing threads");
		ArrayList<Thread> ArrayOfThread = new ArrayList<>();
		int countThread=1;
		while (!queueResourses.isEmpty()) {
			String resourseName = queueResourses.remove();
			Thread t2 = new ProceedingResourse("Processing -"+countThread++,groupThreads, resourseName, mapWordsRate, globalException);
			ArrayOfThread.add(t2);
			t2.start();
		}
		for (Thread thread : ArrayOfThread) {
			if (thread!=null) try {
				logger.info ( "{} join to {}", this.getName(),thread.getName());
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (globalException.getValue()!=null) {
			logger.warn	("Обработка списка ресурсов прервана по причине ошибки, словарь очищен.");
			mapWordsRate.clear();
			globalException.getValue().printStackTrace();
		}
	}
}

