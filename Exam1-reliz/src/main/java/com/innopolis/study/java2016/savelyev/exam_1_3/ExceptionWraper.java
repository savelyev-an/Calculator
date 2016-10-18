package com.innopolis.study.java2016.savelyev.exam_1_3;

/**
 * Обертка для Exception
 * Created by User on 12.10.2016.
 */
public class ExceptionWraper {
	private volatile Exception globalException;

	/**
	 * создает новый объект с пустым значением Исключения
	 */
	public ExceptionWraper() {this.globalException = null;}

	/**
	 * Возвращет значение Исключения, находящегося в Обертке
	 * @return
	 */
	public Exception getValue() { return globalException;}

	/**
	 * Помещает значение переданного исключения в Обертку
	 * @param globalException
	 */
	public void setValue(Exception globalException ) {this.globalException = globalException;}
}
