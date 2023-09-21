package com.passport.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.passport.Base.TestBase;

public class VerifyDepositFunc extends TestBase {
	
	@Test
	public void verifyDepositMoney() throws InterruptedException {
		/*
		 * WebElement until =
		 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.
		 * cssSelector("CustomerLogin")))); until.click();
		 */
		driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-lg'])[1]")).click();
		WebElement yourName = driver.findElement(By.id(OR.getProperty("YourName")));
		dropDown(yourName, "Vinothkumar Gnanasekaran");
		driver.findElement(By.cssSelector(OR.getProperty("Login"))).click();
		Assert.assertEquals("Vinothkumar Gnanasekaran", driver.findElement(By.cssSelector(OR.getProperty("labelName"))).getText());
		driver.findElement(By.cssSelector(OR.getProperty("depositButton"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("amount"))).sendKeys("7000");
		driver.findElement(By.cssSelector(OR.getProperty("depositSubmitButton"))).click();
		String amount = driver.findElement(By.xpath(OR.getProperty("Balance"))).getText();
		int amountInt = Integer.parseInt(amount);
		System.out.println("Account balance  "+amountInt);
		String text = driver.findElement(By.cssSelector(OR.getProperty("Message"))).getText();
		System.out.println(text+"********************");
		Assert.assertEquals("Deposit Successful", text);
	}
	
	@Test(dependsOnMethods = "verifyDepositMoney",invocationCount=50)
	public void verifyAccountBalance() {
		driver.findElement(By.cssSelector(OR.getProperty("amount"))).sendKeys("100000");
		driver.findElement(By.cssSelector(OR.getProperty("depositSubmitButton"))).click();
		String amount = driver.findElement(By.xpath(OR.getProperty("Balance"))).getText();
		int amountInt = Integer.parseInt(amount);
		System.out.println("Account balance  "+amountInt);
		String text = driver.findElement(By.cssSelector(OR.getProperty("Message"))).getText();
		System.out.println(text+"********************");
		Assert.assertEquals("Deposit Successful", text);
	}
	}
	
	


