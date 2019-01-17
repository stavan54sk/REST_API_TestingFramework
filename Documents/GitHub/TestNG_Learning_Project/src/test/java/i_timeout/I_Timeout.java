package i_timeout;

import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/
public class I_Timeout {

	@Test(timeOut=4000)
	public void FirstTest() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("FirstTest");
	}
	
	@Test()
	public void SecondTest() throws InterruptedException {
		Thread.sleep(4000);
	}


}
