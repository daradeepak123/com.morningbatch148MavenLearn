package testNgLearn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.BrowserSelection;
import utils.ExcelUtils;
import utils.SeleniumHelper;

public class TestNgBasic {
	
	public Properties xpathRepo;
	public WebDriver driver;
	String brw="ff";
	XSSFWorkbook wb;
	XSSFSheet sheet;
	File file;
	FileInputStream fis;
	public String creds[];
	public SeleniumHelper sh=new SeleniumHelper();
	BrowserSelection bs=new BrowserSelection();
	ExcelUtils eu=new ExcelUtils();
	String fil=System.getProperty("user.dir")+"\\src\\main\\resources\\congif.properties";

	String fil1=System.getProperty("user.dir")+"\\src\\test\\resources\\eleRepo.properties";
	public String url;
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		System.out.println("this is before suite");
		File file=new File(fil);
		FileInputStream fis=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("address"));
		String ss=prop.getProperty("address");
		String sht=prop.getProperty("sheet");
		url=prop.getProperty("site");
		creds=new String[2];
		//creds=eu.callCellData("c:\\demo\\employee.xlsx", "Sheet2");
		creds=eu.callCellData(ss, sht);
		
		
		File file1=new File(fil1);
		FileInputStream fis1=new FileInputStream(file1);
		xpathRepo=new Properties();
		xpathRepo.load(fis1);
		
		
	}
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver=bs.selectBrowser(driver);
	}
	
	
	
	
	@AfterTest
	public void AfterTest()
	{
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() throws IOException
	{
		wb.close();
		System.out.println("after suite");
	}
	
}
