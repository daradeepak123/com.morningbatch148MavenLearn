package utils;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumHelper {
	
	public static Logger log= LogManager.getLogger(SeleniumHelper.class);;

	
	public void clickOnElementByClass(WebDriver driver,By elee)
	{	
		log= LogManager.getLogger(SeleniumHelper.class);
		WebElement ele=driver.findElement(elee);
		boolean bool=ele.isEnabled();
		bool&=ele.isDisplayed();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(elee));
		if(bool)
		{
			try {
			ele.click();
			log.info("I am successful in clicking webelement");
			}
			catch(ElementClickInterceptedException e)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
				log.info("NOt able to click on element with WebElement method so clicked with JS");
			}
		}
		else
		{
			System.out.println("not able to click the webElement");
			log.error("System is unalbe to find the webelement midht not visibled/displayed");
		}
	}
	
	public void clickOnElement(WebDriver driver,String xpath)
	{	
		WebElement ele=driver.findElement(By.xpath(xpath));
		boolean bool=ele.isEnabled();
		bool&=ele.isDisplayed();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		if(bool)
		{
			ele.click();			
		}
		else
		{
			System.out.println("not able to click the webElement");
		}
	}
	
	
	public List<WebElement> getElements(WebDriver driver, String xpath)
	{
		
		List<WebElement> ele=driver.findElements(By.xpath(xpath));
		log.info("List of webelements collected and returned to execution class");
		return ele;	
		
	}
	
	public void getTextPrint(WebDriver driver, WebElement ele)
	{
		
		String str=ele.getText();
		System.out.println(str);
		
	}
	
	
	
	
	public void sendDataTextBox(WebDriver driver,String xpath,String data)
	{	
		WebElement ele=driver.findElement(By.xpath(xpath));
		boolean bool=ele.isEnabled();
		bool&=ele.isDisplayed();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(bool)
		{
			ele.sendKeys(data);;			
		}
		else
		{
			System.out.println("not able to click the webElement");
		}
	}
	
	public void sendDataTextBoxByclass(WebDriver driver,By xpath,String data)
	{	
		WebElement ele=driver.findElement(xpath);
		boolean bool=ele.isEnabled();
		bool&=ele.isDisplayed();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
		if(bool)
		{
			ele.sendKeys(data);;			
		}
		else
		{
			System.out.println("not able to click the webElement");
		}
	}
	

}
