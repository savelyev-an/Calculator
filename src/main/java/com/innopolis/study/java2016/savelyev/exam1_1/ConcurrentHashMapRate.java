package com.innopolis.study.java2016.savelyev.exam1_1;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by User on 06.10.2016.
 */
public class ConcurrentHashMapRate <KeyClass> {
	private ConcurrentHashMap <KeyClass, Integer> worhause = new ConcurrentHashMap <>();
	public void put (KeyClass keyObject){
		int rate;
		synchronized (worhause) {
			if (worhause.containsKey(keyObject)) rate = worhause.get(keyObject).intValue();
			else rate = 0;
			worhause.put(keyObject, (Integer) (rate + 1));
		}
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