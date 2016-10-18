package com.innopolis.study.java2016.savelyev.exam_1_reliz_unsupported;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by User on 06.10.2016.
 */
public class ConcurrentHashMapRate<KeyClass> {
	private ConcurrentHashMap <KeyClass, Integer> worhause = new ConcurrentHashMap <>();

	private int size=0;

	public void put (KeyClass keyObject){
		this.putPlusRate(keyObject,1);
	}

	public int get (KeyClass keyObject) {// использовать int или Integer ?
		return worhause.get (keyObject).intValue();
	}

	public int getSize() {
		return size;
	}

	public void list () {
		Iterator entries = worhause.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry thisEntry = (Map.Entry) entries.next();
			Object key = thisEntry.getKey();
			Object value = thisEntry.getValue();
			System.out.println(key+" встречается "+ value + " раз(a)");
		}
	}

	private void putPlusRate (KeyClass keyObject, int n){
		int rate;
		synchronized (worhause) {
			if (worhause.containsKey(keyObject)) rate = worhause.get(keyObject).intValue();
			else {rate = 0; size++;}
			worhause.put(keyObject, (Integer) (rate + n));
		}
	}

	public Set<Map.Entry<KeyClass, Integer>> entrySet() {
		return worhause.entrySet();
		}

	public void add (ConcurrentHashMapRate<KeyClass> addingMap){
		Iterator entries = addingMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry thisEntry = (Map.Entry) entries.next();
			KeyClass key = (KeyClass)thisEntry.getKey();
			int value = (int)(thisEntry.getValue());
			this.putPlusRate(key,value);
		}
	}

	public void clear (){
		worhause.clear();
	}
}