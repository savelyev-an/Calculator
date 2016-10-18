package com.innopolis.study.java2016.savelyev.exam1_1;


/**
 * Метод выполняющий задачу импорта потока слов из заданных ресурсов и формирования частотного словаря
 */
public class StartPoint {
	static ConcurrentHashMapRate<String> myDict=new ConcurrentHashMapRate<>();


	static class MainThread {
		ConcurrentHashMapRate<String> myDict;

		public MainThread(ConcurrentHashMapRate<String> myDict) {
			this.myDict= myDict;
		}

		void doMainCycle(String resourseSourse) {
			//while (true) {
				// проверим источник ресурсов
				// если ресурс 	получен
				// запускаем поток-трубопровод с функциями контроля ошибки:
			//}
			TransportFromResourse2Dict t1=new TransportFromResourse2Dict(myDict, ".\\Source.txt");
			t1.run();
		}
	}

	public static void main(String[] args) {
		MainThread t = new MainThread (myDict);
		t.doMainCycle("  ");//args[0]);
		myDict.list();
	}

//	public static void main(String[] args) {
//		ConcurrentHashMapRate <String> myDict= new ConcurrentHashMapRate<>();
//		myDict.put("Мама");
//		myDict.put("Мама");
//		myDict.put("Мама");
//		myDict.put("Мама");
//		myDict.put("Папа");
//		myDict.list();
//	}
}

