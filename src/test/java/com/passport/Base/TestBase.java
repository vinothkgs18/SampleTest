package com.passport.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.passport.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	/*
	 * WebDriver
	 * Properties
	 * Logs
	 * Extended Reports
	 * DB
	 * Excel
	 * mail
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=LogManager.getLogger(TestBase.class);
	public static WebDriverWait wait;
	public ExtentReports reo=ExtentManager.getInstance();
	public static ExtentTest test;
	//devpinoyLogger
	
	
	
	@BeforeSuite
	@Parameters({"browser"})
	public void setUp(String browser){
		
		if(driver==null) {
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				log.debug("Helo chrome");
			}
			
			else if(browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}

		}
		driver.get(config.getProperty("environment"));
		log.debug("Testing file loger");
		driver.manage().window().maximize();
		log.debug("Testing file loger");
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitlyWait")), TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 10);
		
	}
	@AfterSuite
	public void tearDown() {
		
		if(driver!=null) {
		//driver.close();
		}
	}
	
	public static void dropDown(WebElement i, String a) { 
		Select s=new Select(i);
		s.selectByVisibleText(a);
	}

}
