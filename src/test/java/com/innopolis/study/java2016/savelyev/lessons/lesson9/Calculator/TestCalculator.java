package com.innopolis.study.java2016.savelyev.lessons.lesson9.Calculator;

import com.innopolis.study.java2016.savelyev.lessons.lesson9.jUnit_1.HelloWorld;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 * Created by User on 13.10.2016.
 */
public class TestCalculator {
	private static Logger logger = LoggerFactory.getLogger(TestCalculator.class);
	private Calculator calculator;

	@BeforeClass
	public static void beforeTest (){
		logger.info("this is @BeforeClass method for TestCalculator");

	}

	@Before
	public void before(){
		logger.info("this is @Before method");
		this.calculator = new Calculator();
	}


	@Test
	public void testSum (){
		logger.info("Test Sum");
		assertEquals ("Вернулась неправильная сумма " , calculator.sum(999,1000),((double)1000+ (double)999),0.00001);
	}

	@Test
	public void testMinus (){
		logger.info("Test Minus");
		assertEquals ("Вернулась неправильная разность " , calculator.minus(1999,1000),((double)1999- (double)1000),0.00001);
	}

	@Test
	public void testMultiply (){
		logger.info("Test Multiply");
		assertEquals ("Вернулась неправильная произведение " , calculator.multiply(1999,1000),((double)1999* (double)1000),0.00001);
	}


	@Test
	public void testDevision (){
		logger.info("Test Devision");
		assertEquals ("Вернулась неправильная частное " , calculator. division(1999,1000),((double)1999/ (double)1000),0.00001);
	}

	@Test
	public void testSqrt (){
		logger.info("Test Sqrt");
		assertEquals ("Вернулась неправильный корень " , calculator. sqrt(1999) , Math.sqrt((double)1999) , 0.00001);
	}


	@AfterClass
	public static void afterClass(){
		logger.info("this is @AfterClass method");

	}
}
