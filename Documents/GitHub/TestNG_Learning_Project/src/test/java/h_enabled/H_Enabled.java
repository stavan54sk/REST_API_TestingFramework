package h_enabled;

import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/
public class H_Enabled {

	@Test(enabled=false)
	public void FirstTest() {
		System.out.println("FirstTest");
	}

	@Test(enabled=false)
	public void SecondTest() {
		System.out.println("SecondTest");
	}

	@Test(enabled=false)
	public void ThirdTest() {
		System.out.println("ThirdTest");
	}

	@Test(enabled=false)
	public void FourthTest() {
		System.out.println("FourthTest");
	}

	@Test(enabled=true)
	public void FifthTest() {
		System.out.println("FifthTest");
	}

	@Test(enabled=true)
	public void SixthTest() {
		System.out.println("SixthTest");
	}

	@Test(enabled=true)
	public void SeventhTest() {
		System.out.println("SeventhTest");
	}

	@Test(enabled=true)
	public void EighthTest() {
		System.out.println("EighthTest");
	}

	@Test()
	public void NinthTest() {
		System.out.println("NinthTest");
	}
}
