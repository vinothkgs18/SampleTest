package com.passport.testcase;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.passport.Base.TestBase;
import com.passport.utilities.Utillities;

public class VerifyCustomer extends TestBase{

	
	@Test(dataProvider="getData")
	public void searchCustomer(String name) {
		driver.findElement(By.cssSelector(OR.getProperty("ShowCustomerButton"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("SearchCustomer"))).clear();
		driver.findElement(By.cssSelector(OR.getProperty("SearchCustomer"))).sendKeys(name);
		System.out.println(driver.findElement(By.xpath(OR.getProperty("CustomerData"))).getText());
		Assert.assertEquals(name, driver.findElement(By.xpath(OR.getProperty("CustomerData"))).getText());
	}
	
	@DataProvider
	public Object[][] getData(){
		String[][] data = Utillities.getDataFromExcel("./src/test/resources/excel/AddCustomerDetails.xlsx", 2);
		return data;
	}
}
