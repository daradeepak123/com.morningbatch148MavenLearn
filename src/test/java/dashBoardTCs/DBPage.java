package dashBoardTCs;

import org.testng.annotations.Test;

public class DBPage {	
	
	@Test(priority = 7)
	public void testcase()
	{
		System.out.println("this is test case");
	}
	
	@Test(priority = 6)
	public void abctestcase5()
	{
		System.out.println("this is test case5");
	}
	@Test(priority = 5)
	public void aactestcase5()
	{
		System.out.println("this is test case5");
	}
	
	@Test(priority = 4)
	public void testcase1()
	{
		System.out.println("this is test case1");
	}
	
	@Test(priority = 1)
	public void testcase2()
	{
		System.out.println("this is test case2");
	}
	
	@Test(priority = 2, enabled = false)
	public void testcase3()
	{
		System.out.println("this is test case3");
	}
	
	@Test(priority = 4, invocationCount = 3,description = "this is normal text",dependsOnMethods = "testcase2")
	public void testcase4()
	{
		System.out.println("this is test case4");
	}
	
	
	
	
	

}
