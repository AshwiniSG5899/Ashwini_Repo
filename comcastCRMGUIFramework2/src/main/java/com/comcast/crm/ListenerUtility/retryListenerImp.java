package com.comcast.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryListenerImp implements IRetryAnalyzer {

	int Count=0;
	int limitCount=5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean retry(ITestResult result) {
		if(Count<limitCount)
		{
			Count++;
			return true;
		}
		else {
		return false;
		}
	}

}
