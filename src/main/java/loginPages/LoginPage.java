package loginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumHelper;

public class LoginPage {
	
	//private By uNameTB=By.xpath("//input[@name='usernamee']");
	private By pwdTB=By.xpath("//input[@name='password']");
	private By loginBTN=By.xpath("//button");
	
	private SeleniumHelper sh=new SeleniumHelper();
	
	
	
	public void login(WebDriver driver,String uname,String pwd)
	{
		sh.sendDataTextBoxByclass(driver, By.xpath("//input[@name='usernamee']"), uname);
		sh.sendDataTextBoxByclass(driver, pwdTB, pwd);
		sh.clickOnElementByClass(driver, loginBTN);
	}

}
