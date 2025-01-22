package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericWebDriverUtility.WebDriverUtility;

public class CreateNewContactPage {
	
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(name="lastname")
public WebElement lastNameedit;

@FindBy(name="support_start_date")
public WebElement startdateEdit;

@FindBy(name="support_end_date")
public WebElement endDateEdit;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
public WebElement saveBtn;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
public WebElement selectOrgBtn;

@FindBy(name="search_text")
public WebElement searchtextEdit;

@FindBy(name="search")
public WebElement childSearchBtn;


public WebElement getLastNameedit() {
	return lastNameedit;
}

public WebElement getStartdateEdit() {
	return startdateEdit;
}

public WebElement getendDateEdit() {
	return endDateEdit;
}


public WebElement getSelectOrgBtn() {
	return selectOrgBtn;
}


public WebElement getSearchtextEdit() {
	return searchtextEdit;
}

public WebElement getChildSearchBtn() {
	return childSearchBtn;
}

public void createContact(String Contact)
{
	lastNameedit.sendKeys(Contact);
	saveBtn.click();
	
}
public void createContact(String lastName,String startDate,String endDate)
{
	lastNameedit.sendKeys(lastName);
	startdateEdit.sendKeys(startDate);
	endDateEdit.sendKeys(endDate);
	saveBtn.click();
}
public void createContact(String lastName,String orgName,String childwindowurl,String parentWindowurl)
{
	lastNameedit.sendKeys(lastName);
	selectOrgBtn.click();
	WebDriverUtility wLib=new WebDriverUtility();
	wLib.switchNewBrowserTab(driver, childwindowurl);
	searchtextEdit.sendKeys(orgName);
	childSearchBtn.click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	wLib.switchNewBrowserTab(driver, parentWindowurl);
	saveBtn.click();
	
	
}


}
