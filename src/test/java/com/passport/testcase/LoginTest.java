package com.passport.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.passport.Base.TestBase;

public class LoginTest extends TestBase {
	
	
	@Test
	public void loginAsBankManager() {
		//log.debug("testting log");
		driver.findElement(By.cssSelector(OR.getProperty("bankManagerLoginButton"))).click();
		Assert.assertEquals(driver.getTitle(), "Protractor practice website - Banking App");
		
	}

}
