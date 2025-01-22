package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseClassUtility.BaseClass;
import com.comcast.crm.genericWebDriverUtility.UtilityClassObject;

public class ListImpClass implements ITestListener,ISuiteListener{

	
	public static ExtentReports report=null;
	public ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configuration");
		//spark report config
		String time=new Date().toString().replace(" ","_").replace(":","_");
		spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create Test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==="+result.getMethod().getMethodName()+"====STARTS====");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"==>Started<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==="+result.getMethod().getMethodName()+"====ENDS====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==>Completed<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)(BaseClass.sdriver);
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":","_");
		File dest=new File("./Screenshots/"+testName+"+"+time+".png");
		test.addScreenCaptureFromBase64String(filepath, "errorFile");
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==>Failed<==");
		
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
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
