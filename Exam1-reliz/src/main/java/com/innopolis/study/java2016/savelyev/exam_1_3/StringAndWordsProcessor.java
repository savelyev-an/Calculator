package com.innopolis.study.java2016.savelyev.exam_1_3;

import java.util.regex.Pattern;

/**
 * Абстрактный класс содержащий методы обработки строк и слов
 * Created by User on 13.10.2016.
 */
public abstract class StringAndWordsProcessor {
	/**
	 * Паттерн позволяющий разбивать методом split строку на слова составленные из русских и(или) латинских букв,
	 * остальные символы считаются разделителями и в выходном массиве Array[]String - отсутствуют
	 */
	static public Pattern SEPARATORS = Pattern.compile("[^A-Za-zА-Яа-я]+");
	/**
	 * Паттерн позволяющий проводить проверку String на наличие там СТРОГО букв русского алфавита
	 * (пробелы и цифры считаются не символами русского алфиавита)
	 */
	static public String RUSSIAN_LETTERS ="[А-Яа-я]+";

	/**
	 * Возвращает true если string состоит строго из букв в соответствии RUSSIAN_LETTERS
	 * @param string
	 * @return
	 */
	static public boolean isRussian(String string){
		boolean result= false;
		if (string!=null) {
			result = string.matches(RUSSIAN_LETTERS);
		}
		return result;
	}

	/**
	 * Возвращает String []Array, полученный путем разбиения строки аргумента на слова в соответствии с
	 * паттерном SEPARATORS
	 * @param string
	 * @return
	 */
	static public String[] getWordsFromString (String string){
		return  SEPARATORS .split(string);
	}
}
