package com.innopolis.study.java2016.savelyev.exam_1_3;

/**
 * Класс исключения созданный для хранения информации об исключении связанного с ошибкой
 * открытия ресурса
 * Created by User on 12.10.2016.
 */
public class OpenResourseException extends ForeignWordException {

	/**
	 * Создает ошибку с полями определенными в родительском классе
	 * @param threadName
	 * @param resourseName
	 * @param message
	 */
	public OpenResourseException(String threadName, String resourseName, String message) {
		super(threadName, resourseName, message);
	}

	/**
	 * Создает ошибку с полями определенными в родительском классе
	 * @param threadName
	 * @param resourseName
	 * @param message
	 * @param e
	 */

	public OpenResourseException(String threadName, String resourseName, String message, Exception e) {
		super(threadName, resourseName, message, e);
	}
}
