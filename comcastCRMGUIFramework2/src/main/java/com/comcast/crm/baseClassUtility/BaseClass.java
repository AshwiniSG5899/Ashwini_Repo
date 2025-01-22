package com.comcast.crm.baseClassUtility;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.comcast.crm.genericDatabaseUtility.DatabaseUtility;
import com.comcast.crm.genericFileUtility.ExcelUtility;
import com.comcast.crm.genericFileUtility.FileUtility;
import com.comcast.crm.genericWebDriverUtility.JavaUtility;
import com.comcast.crm.genericWebDriverUtility.UtilityClassObject;
import com.comcast.crm.genericWebDriverUtility.WebDriverUtility;

public class BaseClass {

	public DatabaseUtility DbLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility Wlib=new WebDriverUtility();
	public ExcelUtility exl=new ExcelUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	ExtentReports report=null;
	ExtentSparkReporter spark=null;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("connect to db and report config");
		DbLib.getDBConnection("jdbc:mysql://localhost:3306/sakila","root","rmgy@9999");
		
	
		
	}
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable
	{
		System.out.println("==Launch the browser==");
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		//String BROWSER=System.getProperty("browser");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable
	{
		System.out.println("==Login==");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		LoginPage Lp=new LoginPage(driver);
		Lp.LoginToApp(URL, USERNAME, PASSWORD);
		
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAm()
	{
		System.out.println("==Logout==");
		HomePage hp = new HomePage(driver);
		hp.Logout();
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("==Close the browser==");
		driver.quit();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS()
	{
		System.out.println("==Close the Dbconnection and report backup==");
		DbLib.closeDBConnection();
		
	}
	
	
	

}
