package dashBoardTCs;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testNgLearn.TestNgBasic;


public class DashBoardPageCheck extends TestNgBasic{
	
	
	@BeforeClass
	public void beforeClass()
	{
		driver.get(url);
		sh.sendDataTextBox(driver, "//input[@name='username']", creds[0]);
		sh.sendDataTextBox(driver, "//input[@name='password']", creds[1]);
		sh.clickOnElement(driver, "//button");
		driver.navigate().refresh();
		Assert.assertEquals("OrangeHRM", driver.getTitle());
		
	}
	
	@BeforeMethod
	public void bMethod() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	
	@Test
	public void DashBoardtest()
	{
		List<WebElement> eles=sh.getElements(driver, "//p[text()='Assign Leave']/../../..//p");
		int count=sh.getElements(driver, "//p[text()='Assign Leave']/../../..//p").size();
		for(WebElement el:eles)
		{
			sh.getTextPrint(driver, el);
		}
		
		Assert.assertEquals(6, count);
		
	}
	
	

}
