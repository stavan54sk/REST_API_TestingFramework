package k_dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/
public class K_DataProvider {

	@Test(dataProvider = "SecondTest")
	public void FirstTest(int firstParameter, int secondParameter, int thirdParameter) {

		System.out.println(firstParameter);
		System.out.println(secondParameter);
		System.out.println(thirdParameter);
	}

	
	@DataProvider
	public Object[][] SecondTest() {

		Object[][] o = new Object[3][3];

		o[0][0] = 10;
		o[0][1] = 20;
		o[0][2] = 30;
		o[1][0] = 40;
		o[1][1] = 50;
		o[1][2] = 60;
		o[2][0] = 70;
		o[2][1] = 80;
		o[2][2] = 90;

		return o;

	}

}
