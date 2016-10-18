import com.innopolis.study.java2016.savelyev.lessons.lesson9.jUnit_1.HelloWorld;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import static org.junit.Assert;


/**
 * Created by User on 13.10.2016.
 */
public class HelloWorldTest {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldTest.class);
	private HelloWorld helloWorld;

	@BeforeClass
	public static void beforeTest (){
		logger.info("this is @BeforeClass method");

	}

	@Before
	public void before(){
		logger.info("this is @Before method");
		this.helloWorld = new HelloWorld();
	}

//	@Ignore
	@Test
	public void testIsHelloWorld (){
		logger.info("Test isHelloWorld");
		Assert.assertTrue("Arg is not HelloWorld", this.helloWorld.isHelloWorld("HelloWorld"));
	}

	@Test
	public void isString (){
		logger.info("Test isString");
	}

	@After
	public void after(){
		logger.info("this is @After method");
		Assert.assertTrue("Arg is not sgtring", this.helloWorld.isString("ss"));
	}
	@AfterClass
	public static void afterClass(){
		logger.info("this is @AfterClass method");

	}
}
