package adminTabTCs;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testNgLearn.TestNgBasic;

public class AdminUsersCheck extends TestNgBasic{


	@BeforeClass
	public void beforeClass()
	{
		driver.get(url);
		sh.sendDataTextBox(driver, "//input[@name='username']", creds[0]);
		sh.sendDataTextBox(driver, "//input[@name='password']", creds[1]);
		sh.clickOnElement(driver, "//button");
		Assert.assertEquals("OrangeHRM", driver.getTitle());
		
	}
	
	
	@BeforeMethod
	public void bMethod() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(3000);
	}

	
	
	@Test
	public void testBasic1()
	{
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("Admin");
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		String name= driver.findElement(By.xpath("(//div[text()='Admin'])[1]")).getText();
		Assert.assertEquals("Admin", name);
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
