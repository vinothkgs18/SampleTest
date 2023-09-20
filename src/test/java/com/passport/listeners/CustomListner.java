package com.passport.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.passport.Base.TestBase;
import com.passport.utilities.Utillities;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListner extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//test.log(LogStatus.PASS, result.getName().toUpperCase()+"  PASS");
		//reo.endTest(test);
		//reo.flush();
		Reporter.log(result.getName().toUpperCase()+"  Passed");
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(LogStatus.FAIL, result.getName().toUpperCase()+"  Failed");
		//test.log(LogStatus.FAIL, test.addScreenCapture(Utillities.screenshotName));
		//reo.endTest(test);
		//reo.flush();
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Utillities.captureScreenshot();
		//Reporter.log("<a href=\"D:\\wallpapers\\error.jpg\">screenshot</a>");
		Reporter.log("<a href="+Utillities.screenshotName+">screenshot</a>");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		reo.startTest(context.getName().toUpperCase());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
