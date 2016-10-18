package com.innopolis.study.java2016.savelyev.exam_1_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by User on 13.10.2016.
 */
public class TestConcurentHashMapRate {
	private final String ABCDEF="ABCDEF";
	private final String ABCD="ABCD";
	private static Logger logger = LoggerFactory.getLogger(TestConcurentHashMapRate.class);

	@BeforeClass
	public static void beforeTest (){
		logger.info("this is @BeforeClass method for TestConcurentHashMapRate");
	}

	@Before
	public void before(){
		logger.info("this is @Before method");
	}


	@Test
	public void testPutAndGet (){
		logger.info("testPutAndGet -  Start");
		ConcurrentHashMapRate<String> concurrentHashMapRate= new ConcurrentHashMapRate<>();
		logger.info("testPutAndGet- 1");
		assertTrue ("Вернулось неверное значение  частоты для 0" , concurrentHashMapRate.get(ABCDEF)==0);
		concurrentHashMapRate.put(ABCDEF);
		logger.info("testPutAndGet- 2");
		assertTrue ("Вернулось неверное значение  частоты для 1" , concurrentHashMapRate.get(ABCDEF)==1);
		concurrentHashMapRate.put(ABCDEF);
		logger.info("testPutAndGet- 3");
		assertTrue ("Вернулось неверное значение  частоты для 2" , concurrentHashMapRate.get(ABCDEF)==2);
		logger.info("testPutAndGet- 4");
		assertTrue ("Вернулось неверное значение  частоты для 0 " , concurrentHashMapRate.get(ABCD)==0);
	}

	@Test
	public void testGetSize (){
		logger.info("testGetSize - Start ");
		ConcurrentHashMapRate<String> concurrentHashMapRate= new ConcurrentHashMapRate<>();
		logger.info("testGetSize - 0");
		assertTrue ("Вернулось неверное значение  размера для  0" , concurrentHashMapRate.getSize()==0);
		concurrentHashMapRate.put(ABCDEF);
		logger.info("testGetSize - 1");
		assertTrue ("Вернулось неверное значение  размера для 1" , concurrentHashMapRate.getSize()==1);
		concurrentHashMapRate.put(ABCD);
		logger.info("testGetSize - 2");
		assertTrue ("Вернулось неверное значение  размера для 2" , concurrentHashMapRate.getSize()==2);
		concurrentHashMapRate.put(ABCD);
		logger.info("testGetSize - 2_2");
		assertTrue ("Вернулось неверное значение  размера для 2" , concurrentHashMapRate.getSize()==2);
	}

	@Test
	public void testClear () {
		logger.info("testClear - Start ");
		ConcurrentHashMapRate<String> concurrentHashMapRateEmpty = new ConcurrentHashMapRate<>();
		ConcurrentHashMapRate<String> concurrentHashMapRate = new ConcurrentHashMapRate<>();
		logger.info("testClear - 0");
		assertTrue ("Неправильное состояние для пустого словаря" ,
				concurrentHashMapRate.equals(concurrentHashMapRateEmpty));
		logger.info("testClear - 1");
		concurrentHashMapRate.put(ABCD);
		concurrentHashMapRate.clear();
		assertTrue ("Неправильное состояние для словаря в который что-то положили и очистили" ,
				concurrentHashMapRate.equals(concurrentHashMapRateEmpty));
	}


		@AfterClass
	public static void afterClass(){
		logger.info("this is @AfterClass method");

	}
}
