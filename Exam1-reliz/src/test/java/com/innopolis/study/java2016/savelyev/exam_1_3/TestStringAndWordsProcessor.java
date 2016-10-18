package com.innopolis.study.java2016.savelyev.exam_1_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by User on 13.10.2016.
 */
public class TestStringAndWordsProcessor {
	private final String Несколько_РУССКИХ_слов="Несколько_РУССКИХ слов";
	private final String[] Array_Несколько_РУССКИХ_слов={"Несколько","РУССКИХ","слов"};

	private final String Несколько_РУССКИХ_слов_andнесовсемрусских=
			"Несколько_РУССКИХ_слов andнесовсемрусских";
	private final String[] Array_Несколько_РУССКИХ_слов_andнесовсемрусских=
			{"Несколько","РУССКИХ","слов","andнесовсемрусских"};

	private final String SOME_WORDS_WITH_SEPARATORS ="one,two.three, four:five";
	private final String[] Array_SOME_WORDS_WITH_SEPARATORS ={"one","two","three","four","five"};

	private final String ТОльКОрусскиеБуквы="ТОльКОрусскиеБуквы";
	private final String ТОльКОрусскиеБуквы_и_пробелы="ТОльКОрусскиеБуквы и пробелы";
	private final String русскиеИenglishБуквы="русскиеИenglishБуквы";


	private static Logger logger = LoggerFactory.getLogger(TestConcurentHashMapRate.class);

	@BeforeClass
	public static void beforeTest (){
		logger.info("this is @BeforeClass method for TestStringAndWordsProcessor");
	}

	@Before
	public void before(){
		logger.info("this is @Before method");
	}

	@Test
	public void testGetWordsFromString () {
		logger.info("testGetWordsFromString - Start ");
		String[] words;

		logger.info("testGetWordsFromString -1");
		words = StringAndWordsProcessor.getWordsFromString(Несколько_РУССКИХ_слов);
		assertTrue("testGetWordsFromString -1 - false",
				CompareTwoStringArray(words, Array_Несколько_РУССКИХ_слов));

		logger.info("testGetWordsFromString -2");
		words = StringAndWordsProcessor.getWordsFromString(Несколько_РУССКИХ_слов_andнесовсемрусских);
		assertTrue("testGetWordsFromString -1 - false",
				CompareTwoStringArray(words, Array_Несколько_РУССКИХ_слов_andнесовсемрусских));

		logger.info("testGetWordsFromString -3");
		words = StringAndWordsProcessor.getWordsFromString(SOME_WORDS_WITH_SEPARATORS);
		assertTrue("testGetWordsFromString -1 - false",
				CompareTwoStringArray(words, Array_SOME_WORDS_WITH_SEPARATORS));

	}

	private boolean CompareTwoStringArray (String[] array1, String [] array2 ){
		boolean result = true;
		if (array1.length!=array2.length) result=false;
		else {
			for (int i=0;i<array1.length ; i++){
				if (!array1[i].equals(array2[i])) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	@Test
	public void testIsRusian () {
		logger.info("testIsRusian - Start ");

		logger.info("testIsRusian -1");
		assertTrue("testIsRusian -1 - false",
				StringAndWordsProcessor.isRussian(ТОльКОрусскиеБуквы) );

		logger.info("testIsRusian -2");
		assertFalse("testIsRusian -2 - false",
				StringAndWordsProcessor.isRussian(ТОльКОрусскиеБуквы_и_пробелы) );

		logger.info("testIsRusian -3");
		assertFalse("testIsRusian -3 - false",
				StringAndWordsProcessor.isRussian(русскиеИenglishБуквы) );

	}

	@AfterClass
	public static void afterClass(){
		logger.info("this is @AfterClass method");

	}
}
