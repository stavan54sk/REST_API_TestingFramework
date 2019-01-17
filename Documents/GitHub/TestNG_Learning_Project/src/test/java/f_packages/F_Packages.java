package f_packages;

import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/
public class F_Packages {

	@Test(groups={"Smoke"})
	public void FirstTest() {
		System.out.println("A Smoke FirstTest");
	}

	@Test(groups={"Smoke"})
	public void SecondTest() {
		System.out.println("A Smoke SecondTest");
	}

	@Test(groups={"Smoke"})
	public void ThirdTest() {
		System.out.println("A Smoke ThirdTest");
	}

	@Test(groups={"Sanity"})
	public void FourthTest() {
		System.out.println("A Sanity FourthTest");
	}

	@Test(groups={"Sanity"})
	public void FifthTest() {
		System.out.println("A Sanity FifthTest");
	}

	@Test(groups={"Sanity"})
	public void SixthTest() {
		System.out.println("A Sanity SixthTest");
	}

	@Test(groups={"Smoke","Sanity"})
	public void SeventhTest() {
		System.out.println("A Sanity,Smoke SeventhTest");
	}

	@Test(groups={"Smoke","Sanity"})
	public void EighthTest() {
		System.out.println("A Sanity,Smoke EighthTest");
	}

	@Test(groups={"Smoke","Sanity"})
	public void NinthTest() {
		System.out.println("A Sanity,Smoke NinthTest");
	}
}
