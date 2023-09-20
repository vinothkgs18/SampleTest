package com.passport.testcase;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.passport.Base.TestBase;

public class VerifyCustomer extends TestBase{

	
	@Test
	public void searchCustomer() {
		driver.findElement(By.cssSelector(OR.getProperty("ShowCustomerButton"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("SearchCustomer"))).sendKeys("Vinothkumar");
		System.out.println(driver.findElement(By.xpath(OR.getProperty("CustomerData"))).getText());
		Assert.assertEquals("Vinothkumar", driver.findElement(By.xpath(OR.getProperty("CustomerData"))).getText());
	}
}
