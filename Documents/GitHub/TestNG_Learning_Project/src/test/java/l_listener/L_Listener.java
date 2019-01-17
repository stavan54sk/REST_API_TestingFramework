package l_listener;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
@author Stavan S. Kodolikar
*
*
*/
public class L_Listener {
	
	@Test
	public void firstTest()
	{
		System.out.println("First Test");
		Assert.assertTrue(true);
	}
	
	@Test
	public void SecondTest()
	{
		System.out.println("Second Test");
		Assert.assertTrue(false);
		
	}
}
