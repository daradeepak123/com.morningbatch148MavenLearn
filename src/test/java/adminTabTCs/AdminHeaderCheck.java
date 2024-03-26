package adminTabTCs;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginPages.LoginPage;
import testNgLearn.TestNgBasic;

public class AdminHeaderCheck extends TestNgBasic{
	String userName="//input[@name='username']";
	
	
	@BeforeClass
	public void beforeClass()
	{
		LoginPage lp=new LoginPage();
		driver.get(url);
		lp.login(driver, creds[0], creds[1]);
		Assert.assertEquals("OrangeHRM", driver.getTitle());
		
	}
	
	
	@BeforeMethod
	public void bMethod() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(3000);
	}
	
	
	@Test
	public void testBasic()
	{
		String title=driver.findElement(By.xpath("(//h6)[2]")).getText();
		Assert.assertEquals("User Management", title);
	}
	
	
	@AfterMethod
	public void aMethod()
	{
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("Log out");
	}
	
	
	
	

}
