package testNgLearn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaRevise {
	
	
	
	@Test
	public void test()
	{
		SoftAssert sa=new SoftAssert();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button")).click();
		String header2=driver.findElement(By.xpath("(//h6)")).getText();
		System.out.println(header2);
		sa.assertEquals(header2,"User Management","comparing the headers of page");
		sa.assertEquals(true, driver.findElement(By.xpath("(//h6)")).isDisplayed());
		int c=5000+3001;
		sa.assertEquals(8000, c, "c value is coming from data base and comparing with expettaions");
		driver.quit(); 
		
		sa.assertAll();
		
		
	}
	
	
	
	
	
	static int abc;
	
	public static void hello()
	{
		abc=5000;
	}

	public static void main(String[] args) {

		System.out.println(abc);
		hello();
		System.out.println(abc);
		
		
	}

}
