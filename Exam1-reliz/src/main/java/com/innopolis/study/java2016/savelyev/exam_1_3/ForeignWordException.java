package com.innopolis.study.java2016.savelyev.exam_1_3;

/**
 * Класс Исключения предназначенный для хранения информации об исключении, связанном с появлением
 * иностранного символа в одном из открытых ресурсов
 * Created by User on 12.10.2016.
 */
public class ForeignWordException extends Exception {
	private String threadName;
	private String resourseName;

	/**
	 * стандартный конструктор для возможности наследования
	 */
	public ForeignWordException(){super();}

	/**
	 * Конструктор Исключения с параметрами
	 * @param threadName - имя потока, вызвавщего исключениие
	 * @param resourseName - имя ресурса, обрабатывавшегося потоком
	 * @param message - сообщение об ошибке
	 * @param e - исключение, которое вызвало генерацию данного исключения
	 */

	public ForeignWordException(String threadName, String resourseName, String message,  Exception e) {
		super(message, e);
		this.threadName = threadName;
		this.resourseName = resourseName;
	}
	/**
	 * Конструктор Исключения с параметрами
	 * @param threadName - имя потока, вызвавщего исключениие
	 * @param resourseName - имя ресурса, обрабатывавшегося потоком
	 * @param message - сообщение об ошибке
	 */
	public ForeignWordException(String threadName, String resourseName, String message) {
		super(message);
		this.threadName = threadName;
		this.resourseName = resourseName;
	}

	/**
	 * генерация отчета об Исключении, включая вывод информации в полях принадлежащих данному классу
	 */
	public void printStackTrace(){
		System.err.println("Ошибка "+this.getClass().getTypeName());
		System.err.println("Сгенерирована потоком: "+threadName);
		System.err.println("Ресурс: "+ resourseName);
		super.printStackTrace();
	}
}
