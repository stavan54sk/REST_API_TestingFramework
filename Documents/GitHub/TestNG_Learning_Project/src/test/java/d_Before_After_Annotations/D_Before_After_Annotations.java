package d_Before_After_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/

public class D_Before_After_Annotations {
	
	@BeforeSuite
	public void FirstTest()
	{
		System.out.println("A @BeforeSuite Test Case");
	}

	
	@AfterSuite
	public void SecondTest()
	{
		System.out.println("A @AfterSuite Test Case");
	}
	
	@BeforeTest
	public void ThirdTest()
	{
		System.out.println("A @BeforeTest Test Case");
	}
	
	@AfterTest
	public void FourthTest()
	{
		System.out.println("A @AfterTest Test Case");
	}
	
	
	
	@BeforeClass
	public void FifthTest()
	{
		System.out.println("A @BeforeClass Test Case");
	}

	
	@AfterClass
	public void SixthTest()
	{
		System.out.println("A @AfterClass Test Case");
	}
	
	@BeforeMethod
	public void SeventhTest()
	{
		System.out.println("A @BeforeMethod Test Case");
	}
	
	@AfterMethod
	public void EighthTest()
	{
		System.out.println("A @AfterMethod Test Case");
	}
	
	@Test
	public void NinthTest()
	{
		System.out.println("A  Test Case");
	}
}
