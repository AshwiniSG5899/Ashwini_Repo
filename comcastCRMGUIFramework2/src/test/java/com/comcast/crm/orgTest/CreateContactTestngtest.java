package com.comcast.crm.orgTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.draw.geom.GuideIf.Op;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrgPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.ObjectRepositoryUtility.OrgInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseClassUtility.BaseClass;
import com.comcast.crm.genericFileUtility.ExcelUtility;
import com.comcast.crm.genericFileUtility.FileUtility;
import com.comcast.crm.genericWebDriverUtility.JavaUtility;
import com.comcast.crm.genericWebDriverUtility.WebDriverUtility;

@Listeners(com.comcast.crm.ListenerUtility.ListImpClass.class)
public class CreateContactTestngtest extends BaseClass{
	@Test(groups = "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);	
    hp.getOrgLink().click();
    System.out.println("clicked on org link");
    String organization=exl.getDataFromExcel("org", 10, 2)+jLib.getRandomNumber();
	OrganizationsPage op= new OrganizationsPage(driver);
	op.getCreateOrgBtn().click();
	System.out.println("clicked on create org button");
	
	CreateNewOrgPage cp=new CreateNewOrgPage(driver);
	cp.createOrg(organization);
	
	OrgInfoPage orp=new OrgInfoPage(driver);
	String actheader=orp.getOrgHeaderText().getText();
	boolean status1=actheader.contains(organization);
	Assert.assertTrue(status1);
	
	
	}
	
	@Test(groups = "regressionTest")
	public void CreateOrgwithIndustry() throws Throwable, IOException
	{
		HomePage hp=new HomePage(driver);	
	    hp.getOrgLink().click();
	    System.out.println("clicked on org link");
	    String organization=exl.getDataFromExcel("org", 4, 2)+jLib.getRandomNumber();
	    String industry=exl.getDataFromExcel("org", 4, 3);
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		System.out.println("clicked on create org button");
		
		CreateNewOrgPage cp=new CreateNewOrgPage(driver);
		cp.createOrg(organization, industry);
		
		OrgInfoPage orp=new OrgInfoPage(driver);
		String actheader=orp.getOrgHeaderText().getText();
		boolean status=actheader.contains(organization);
		Assert.assertTrue(status);
	}



}
