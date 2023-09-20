package com.passport.testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.passport.Base.TestBase;
import com.passport.utilities.Utillities;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstname, String lastname, String postCode) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String alertExp = "Customer added successfully with customer id";
		driver.findElement(By.cssSelector(OR.getProperty("addCustomerButton"))).click();
		Reporter.log("Clicked Customer add button");
		driver.findElement(By.cssSelector(OR.getProperty("FirstName"))).sendKeys(firstname);
		Reporter.log("Entered Customer first name");
		driver.findElement(By.cssSelector(OR.getProperty("LastName"))).sendKeys(lastname);
		Reporter.log("Entered Customer Last name");
		driver.findElement(By.cssSelector(OR.getProperty("PostCode"))).sendKeys(postCode);
		Reporter.log("Entered Customer Postal code");
		driver.findElement(By.cssSelector(OR.getProperty("AddCustomerButton"))).click();
		Reporter.log("Clicked add Customer Submit button");
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// String text = driver.switchTo().alert().getText();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains(alertExp));
		alert.accept();
		Reporter.log("Customer created successfully");
	}
	
	@Test(/* retryAnalyzer=RetryFaildCase.class */)
	public void demoTEst() {
		Assert.assertFalse(false);
	}

	@DataProvider
	public Object[][] getData() {
		String[][] data = Utillities.getDataFromExcel("./src/test/resources/excel/AddCustomerDetails.xlsx",0);
		return data;

	}

}
