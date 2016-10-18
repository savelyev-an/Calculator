package com.innopolis.study.java2016.savelyev.exam_1_3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Данный класс является расширением класса ConcurrentHashMap, предназначен для формирования частотного
 * словаря объектов JAVA любого класса используемых в качестве ключа
 */
public class ConcurrentHashMapRate<KeyClass> {
	private volatile ConcurrentHashMap <KeyClass, Integer> worhause = new ConcurrentHashMap <>();

	private int size=0;

	/**
	 * Добавляет в словарь информацию об увеличениее на 1 количества раз появления объекта-ключа
	 * @param keyObject
	 */
	public void put (KeyClass keyObject){
		Integer rateWraper;
		int rate;
		rateWraper = worhause.get(keyObject);
		if (rateWraper!=null) rate=rateWraper.intValue()+1;
		else {rate = 1; size++;}
		worhause.put(keyObject, (Integer) (rate));
	}

	/**
	 * Возвращает количество подсчитанных раз вызовов put(KeyObject)
	 * @param keyObject
	 * @return
	 */
	public int get (KeyClass keyObject) {// использовать int или Integer ?
		Integer rateWraper = worhause.get(keyObject);
		if (rateWraper==null) return 0;
		else return rateWraper.intValue();
	}

	/**
	 * Возвращает количество уникальных ключей в словаре
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Выводит на консоль ключи с указанием подсчитанных раз вызовов put(keyObject) для каждого значения
	 * keyObject, встречающегося в словаре
	 */
	public void list () {
		Iterator entries = worhause.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry thisEntry = (Map.Entry) entries.next();
			Object key = thisEntry.getKey();
			Object value = thisEntry.getValue();
			System.out.println(key+" встречается "+ value + " раз(a)");
		}
	}

	private Set<Map.Entry<KeyClass, Integer>> entrySet() {
		return worhause.entrySet();
		}

	/**
	 * Очищает словарь от всех значений
 	 */
	public void clear (){
		size=0;
		worhause.clear();
	}

	/**
	 * Возвращает содержимое словаря в виде HashMap <KeyClass, Integer >, где
	 * KeyClass - класс объектов, используемых в качестве ключа
	 	 * @return
	 */
	public ConcurrentHashMap<KeyClass, Integer> getConcurrentHashMap() {
		return worhause;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConcurrentHashMapRate<?> that = (ConcurrentHashMapRate<?>) o;
		if (size != that.size) return false;
		return worhause != null ? worhause.equals(that.worhause) : that.worhause == null;
	}

	@Override
	public int hashCode() {
		int result = worhause != null ? worhause.hashCode() : 0;
		result = 31 * result + size;
		return result;
	}
}