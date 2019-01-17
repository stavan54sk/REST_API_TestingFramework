package j_parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/
public class J_Parameter {

	@Parameters({ "Single" })
	@Test()
	public void FirstTest(String single) {
		System.out.println(single);

	}

	@Test
	@Parameters({ "Single", "DDouble" })
	public void SecondTest(String single, String ddouble) {

		System.out.println(single);
		System.out.println(ddouble);

	}

	@Test()
	@Parameters({ "Third" })
	public void ThirdTest(String third) {
		System.out.println(third);

	}
	
	@Test()
	@Parameters({ "Fourth" })
	public void FourthTest(String fourth) {
		System.out.println(fourth);

	}

}
