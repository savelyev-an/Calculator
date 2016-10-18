package com.innopolis.study.java2016.savelyev.lessons.lesson9.Streams;

import com.innopolis.study.java2016.savelyev.lessons.lesson9.Calculator.Calculator;
import com.innopolis.study.java2016.savelyev.lessons.lesson9.HelloMock;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 13.10.2016.
 */
public class TestWSSstream {
	private static Logger logger = LoggerFactory.getLogger(TestWSSstream.class);
	private HelloMock helloMock;
	private Mockery context;

	@BeforeClass
	public static void beforeTest (){
		logger.info("this is @BeforeClass method for Wssstreamwriter");

	}

	@Before
	public void before(){
		logger.info("this is @Before method");
		this.helloMock = new HelloMock();
		this.context = new JUnit4Mockery();
	}


	@Test
	public void testHandle (){
		logger.info("Test Handle");
//		StreamWriter sw =new WSStreamWriter(){
//			@Override
//			public Long write (String obj) {
//				return new Long (5);
//			}
//		};
		final StreamWriter streamWriter = context.mock (StreamWriter.class);

		context.checking(new Expectations(){{
			oneOf (streamWriter).write("Sometext");
			will(returnValue(new Long(5)));
		}});
		helloMock.setStreamWriter(streamWriter);
		assertEquals (new Long(5), helloMock.handle("Sometext"));
	}

	@AfterClass
	public static void afterClass(){
		logger.info("this is @AfterClass method");

	}
}
