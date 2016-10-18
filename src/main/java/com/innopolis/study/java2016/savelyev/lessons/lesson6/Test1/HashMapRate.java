package com.innopolis.study.java2016.savelyev.lessons.lesson6.Test1;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Map - ключ - частота объекта с данным значением
 * метод put (ключ) - помещает ключ+частота значений, если ключ есть - увеличиваем на 1
 * getMaxRate - возвращает максимальную частоту в map
 */

public class HashMapRate <KeyClass> {
	private Map<KeyClass, Integer> worhause = new ConcurrentHashMap<KeyClass, Integer>();

	public int getMaxRate() {
		return maxRate;
	}

	private int maxRate;

	public void put (KeyClass keyObject){
		int rate;
		synchronized (worhause) {
			if (worhause.containsKey(keyObject)) rate = worhause.get(keyObject).intValue();
			else rate = 0;
			rate=rate+1;
			worhause.put(keyObject, (Integer) (rate));
		}
		if (rate>maxRate) maxRate=rate;
	}
	public int get (KeyClass keyObject) {// использовать int или Integer ?
		return worhause.get (keyObject).intValue();
	}

	public void list () {
		Iterator entries = worhause.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry thisEntry = (Map.Entry) entries.next();
			Object key = thisEntry.getKey();
			Object value = thisEntry.getValue();
			System.out.println(key.toString()+" встречается "+ value + " раз");
		}
	}

}
