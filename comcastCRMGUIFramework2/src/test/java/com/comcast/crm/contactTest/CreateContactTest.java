package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.ListenerUtility.ListImpClass;
import com.comcast.crm.ObjectRepositoryUtility.ContactsPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrgPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseClassUtility.BaseClass;
import com.comcast.crm.genericFileUtility.ExcelUtility;
import com.comcast.crm.genericFileUtility.FileUtility;
import com.comcast.crm.genericWebDriverUtility.JavaUtility;
import com.comcast.crm.genericWebDriverUtility.UtilityClassObject;

@Listeners(com.comcast.crm.ListenerUtility.ListImpClass.class)
public class CreateContactTest extends BaseClass{

	
	@Test(groups = "smokeTest")
	public void createConTest() throws EncryptedDocumentException, IOException{
		UtilityClassObject.getTest().log(Status.INFO, "reading data from excel");
		FileInputStream fis1=new FileInputStream("C:\\Users\\QSP-Ashtra\\Downloads\\TestScriptData1.xlsx");
        Random random=new Random();
        int randomInt=random.nextInt(1000);
		Workbook wb=WorkbookFactory.create(fis1);
	     Sheet sh=wb.getSheet("Contact");
		 Row row=sh.getRow(1);
		 
		String LastName=row.getCell(2).toString()+randomInt;
		wb.close();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
        ContactsPage ctp=new ContactsPage(driver);
        ctp.getCreateContactBtn().click();
        UtilityClassObject.getTest().log(Status.INFO, "create a contact");
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createContact(LastName);
		
		String HeaderMsg=ctp.getHeaderMsg().getText();
		boolean status=HeaderMsg.contains(LastName);
		Assert.assertEquals(status, true);
		
		
		String ActLastname=driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert asserObj=new SoftAssert();
		asserObj.assertEquals(ActLastname, LastName);
	}
	
	@Test
	public void createContactwithDate() throws EncryptedDocumentException, IOException
	{
		
		
        Random random=new Random();
        int randomInt=random.nextInt(1000);
		ExcelUtility exc=new ExcelUtility();
		JavaUtility Jlib=new JavaUtility();
		 
		String LastName=exc.getDataFromExcel("Contact", 1, 2)+Jlib.getRandomNumber();
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
        ContactsPage ctp=new ContactsPage(driver);
        ctp.getCreateContactBtn().click();
		
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		String StartDate=Jlib.getSystemDateYYYYMMDD();
	    String EndDate=Jlib.getRequiredDateYYYYMMDD(30);
	    ccp.createContact(LastName, StartDate, EndDate);
		
		String Actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		Assert.assertEquals(Actstartdate, StartDate);
		String ActEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		Assert.assertEquals(ActEndDate, EndDate);
		
		}
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws EncryptedDocumentException, IOException
	{
		
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\QSP-Ashtra\\Downloads\\TestScriptData1.xlsx");
        Random random=new Random();
        int randomInt=random.nextInt(1000);
		Workbook wb=WorkbookFactory.create(fis1);
	    Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(4);
		String organization=row.getCell(2).toString()+randomInt;
		 
		Sheet sh1=wb.getSheet("Contact");
		Row row1=sh1.getRow(1);
		 
		String LastName=row1.getCell(2).toString()+randomInt;
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
        CreateNewOrgPage crp=new CreateNewOrgPage(driver);
		crp.createOrg(organization);
        String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean status1=headerInfo.contains(organization);
		Assert.assertTrue(status1);
		
		hp.getContactLink().click();
		ContactsPage ctp=new ContactsPage(driver);
        ctp.getCreateContactBtn().click();
    
        CreateNewContactPage ccp=new CreateNewContactPage(driver);
        ccp.createContact(LastName, organization, "module=Accounts", "module=Contacts");
        
        
        String actContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        boolean status2=actContactHeader.contains(LastName);
        Assert.assertTrue(status2);
        String actOrg=driver.findElement(By.linkText(organization)).getText();
        boolean status3=actOrg.contains(organization);
        Assert.assertTrue(status3);

        
	}

		

	

}
