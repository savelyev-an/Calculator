package com.innopolis.study.java2016.savelyev.test.lessons.lesson5.Syncro1;

/**
 * Совместная работа 2-потоков
 */

public class StartPoint {



	public static void main(String[] args) {
		MyInt seconds = new MyInt();
		Chrono myChrono = new Chrono (seconds);
		myChrono.start();
		Message myMessage5 = new Message(seconds,5);
		Message myMessage7 = new Message(seconds,7);

		myMessage5.start();
		myMessage7.start();
	}


}

