import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.junit.*;

public class SoftAssert {
	static SoftAssertions softAssertions;
	@BeforeClass
	public static void setUp(){
		softAssertions = new SoftAssertions();

	}
	@AfterClass
	public static void tearDown(){
		softAssertions.assertAll();
	}

	@Test
	public void testAssert(){
		softAssert("Alexander","Nikita");
		softAssert("Alexander","Alexander");
		softAssert("Alexander","Sasha");

	}
	@Test
	public void testAssert2(){
		softAssert("Belov","Krasnov");
		softAssert("Alexander","Alexander");
		softAssert("Alexander","Vasya");

	}
	public void softAssert(String actual,String expected){
		softAssertions.assertThat(actual).isEqualTo(expected);
	}
}
