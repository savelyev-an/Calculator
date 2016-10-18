package com.innopolis.study.java2016.savelyev.exam_1_3;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 14.10.2016.
 */
public class TestProceedingResourse {
	private static Logger logger = LoggerFactory.getLogger(TestConcurentHashMapRate.class);

	@BeforeClass
	public static void beforeTest (){
		logger.info("this is @BeforeClass method for TestProceedingResourse");
	}

	@Before
	public void before(){
		logger.info("this is @Before method");

//		queueResourses.add(".\\source2.txt");
//		queueResourses.add(".\\source1.txt");
//		queueResourses.add(".\\source.xt");
	}

	@Test
	public void testRun1 () {
		logger.info("TestProceedingResourse  Run_1- Start ");
		String nameThread= "sample";
		ThreadGroup groupthread=new ThreadGroup("sample");
		String resourseName = ".\\src\\test\\resources\\source2.txt";
		ConcurrentHashMapRate<String> mapWordsRate= new ConcurrentHashMapRate<>();
		ExceptionWraper globalException = new ExceptionWraper();

		Thread t1 = new ProceedingResourse(nameThread,groupthread,
				resourseName, mapWordsRate, globalException);
		t1.run();
		logger.info("словарь сформирован");
		Map<String, Integer> sample= new ConcurrentHashMap<>();
		sample.put("Иннополис", (Integer)100);
		sample.put("Казань", (Integer)100);
		sample.put("Москва", (Integer)100);
		sample.put("Татария", (Integer)100);
		sample.put("Чебоксары", (Integer)100);
		Map<String, Integer> aim=mapWordsRate.getConcurrentHashMap();
		logger.info("словарь-образец  сформирован");
		assertTrue("Словарь  не соответсвует ожидаемому ", isMapEqual(aim, sample));
	}

	@Test
	public void testRun2 () {
		logger.info("TestProceedingResourse  Run_2- Start ");
		String nameThread= "sample";
		ThreadGroup groupthread=new ThreadGroup("sample");
		String resourseName = ".\\src\\test\\resources\\source11.txt";
		ConcurrentHashMapRate<String> mapWordsRate= new ConcurrentHashMapRate<>();
		ExceptionWraper globalException = new ExceptionWraper();
		Thread t1 = new ProceedingResourse(nameThread,groupthread,
				resourseName, mapWordsRate, globalException);
		t1.run();
		logger.info("словарь сформирован");
		Map<String, Integer> sample= new ConcurrentHashMap<>();
		Map<String, Integer> aim=mapWordsRate.getConcurrentHashMap();
		logger.info("пустой словарь образец - сформирован");
		assertTrue("Словарь не соответсвует ожидаемому ", isMapEqual(aim, sample));
	}

	@Test
	public void testRun3 () {
		logger.info("TestProceedingResourse  Run_3- Start ");
		String nameThread= "sample";
		ThreadGroup groupthread=new ThreadGroup("sample");
		String resourseName = ".WrongName";
		ConcurrentHashMapRate<String> mapWordsRate= new ConcurrentHashMapRate<>();
		ExceptionWraper globalException = new ExceptionWraper();
		Thread t1 = new ProceedingResourse(nameThread,groupthread,
				resourseName, mapWordsRate, globalException);
		t1.run();
		logger.info("словарь сформирован");
		Map<String, Integer> sample= new ConcurrentHashMap<>();
		Map<String, Integer> aim=mapWordsRate.getConcurrentHashMap();
		logger.info("пустой словарь образец - сформирован");
		assertTrue("Словарь не соответсвует ожидаемому ", isMapEqual(aim, sample));
	}


	private boolean isMapEqual (Map<String, Integer> aim, Map<String, Integer> sample){
		boolean result=true;
			if (aim==null) result = false;
			else if (aim.isEmpty()!=sample.isEmpty()) result = false;
					else if (!aim.isEmpty()) {
						for (String key : aim.keySet()) {
							if (!aim.get(key).equals(sample.get(key))) {result = false; break;}
						}
					}

		return result;
	}
}
