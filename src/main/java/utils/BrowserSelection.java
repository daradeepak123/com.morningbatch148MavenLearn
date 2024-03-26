package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelection {

	String fil=System.getProperty("user.dir")+"\\src\\main\\resources\\congif.properties";

	
	public WebDriver selectBrowser(WebDriver driver) throws IOException
	{
		File file=new File(fil);
		FileInputStream fis=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("address"));
		String brw=prop.getProperty("brw");
		
		if(brw.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(brw.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(brw.equalsIgnoreCase("Ff"))
		{
			driver=new FirefoxDriver();
		}
		else if(brw.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}

		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	return driver;
		
	}
	
	
	
	
	
	
}
