package com.passport.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFaildCase implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		int retryCount=0;
		int retryCountMax=1;
		if(retryCount<retryCountMax) {
			retryCount++;
			return true;
		}
		return false;
	}

}
