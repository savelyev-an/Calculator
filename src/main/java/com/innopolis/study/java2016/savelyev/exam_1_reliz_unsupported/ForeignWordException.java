package com.innopolis.study.java2016.savelyev.exam_1_reliz_unsupported;

/**
 * Created by User on 12.10.2016.
 */
public class ForeignWordException extends Exception {
	private String threadName;
	private String resourseName;

	public ForeignWordException(){super();}

	public ForeignWordException(String threadName, String resourseName, String message,  Exception e) {
		super(message, e);
		this.threadName = threadName;
		this.resourseName = resourseName;
	}

	public ForeignWordException(String threadName, String resourseName, String message) {
		super(message);
		this.threadName = threadName;
		this.resourseName = resourseName;
	}

	public void printStackTrace(){
		System.out.println("Ошибка содержимого данных");
		System.out.println("Сгенерирована потоком: "+threadName);
		System.out.println("Ресурс: "+ resourseName);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		super.printStackTrace();
	}
}
