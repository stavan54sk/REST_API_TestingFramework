package g_dependOn;

import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/
public class G_DependsOn {

	@Test(groups= {"Smoke"})
	public void FirstTest() {
		System.out.println("Smoke");
	}

	@Test(groups= {"Sanity"},dependsOnGroups= {"Smoke"})
	public void SecondTest() {
		System.out.println("dependsOnGroups Smoke");
	}

	@Test(dependsOnGroups= {"Smoke","Sanity"})
	public void ThirdTest() {
		System.out.println("dependsOnGroups Smoke,Sanity");
	}

	@Test()
	public void FourthTest() {
		System.out.println("FourthTest");
	}

	@Test()
	public void FifthTest() {
		System.out.println("FifthTest");
	}

	@Test(dependsOnMethods="FifthTest")
	public void SixthTest() {
		System.out.println("SixthTest,dependsOnMethods FifthTest");
	}

	@Test(dependsOnMethods="SixthTest")
	public void SeventhTest() {
		System.out.println("SeventhTest,dependsOnMethods SixthTest");
	}

	@Test(dependsOnMethods="SeventhTest")
	public void EighthTest() {
		System.out.println("EighthTest,dependsOnMethods SeventhTest");
	}

	@Test(dependsOnMethods="EighthTest")
	public void NinthTest() {
		System.out.println("NinthTest,dependsOnMethods EighthTest");
	}
}
