package dashBoardTCs;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class INterv {

	public static void main(String[] args) {

		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("iPhone");
		

		driver.findElement(By.xpath("//div[@role='navigation']")).click();
		
		driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
		
		//driver.findElement(By.xpath("")).click();
		
//		List<WebElement> data=driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li//div[@role='option']"));
//		
//		for(WebElement ele:data)
//		{
//			System.out.println(ele.getText());
//			if(ele.getText().equalsIgnoreCase("iPhone"))
//			{
//				ele.click();
//				break;
//			}
//		}
		
		driver.findElement(By.xpath("//span[text()='iPhone | Apple Official Site']")).click();
		
		
	}

}
