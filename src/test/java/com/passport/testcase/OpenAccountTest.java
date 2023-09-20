package com.passport.testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.passport.Base.TestBase;
import com.passport.utilities.Utillities;

public class OpenAccountTest extends TestBase {

	@Test(dataProvider="getData")
	public void openAcc(String customer, String currency) {
		driver.findElement(By.cssSelector(OR.getProperty("OpenAccountButton"))).click();
		dropDown(driver.findElement(By.id(OR.getProperty("Customer"))), customer);
		dropDown(driver.findElement(By.id(OR.getProperty("Currency"))), currency);
		driver.findElement(By.cssSelector(OR.getProperty("ProcessButton"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Account created successfully"));
		alert.accept();
		Reporter.log("Account created successfully");

	}
	
	@DataProvider
	public Object[][] getData() {
		String[][] data = Utillities.getDataFromExcel("./src/test/resources/excel/AddCustomerDetails.xlsx",1);
		return data;

	}


}
