package com.passport.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelBrowser {
	
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void testing(String bro) {
		
		if(bro.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bro.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		
		else if(bro.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		driver.get("https://google.com");
		
	}
	
	@Test
	public void tc1() {
		driver.findElement(By.name("q")).sendKeys("selenium testing");
		driver.findElement(By.name("btnK")).click();
	}

}
