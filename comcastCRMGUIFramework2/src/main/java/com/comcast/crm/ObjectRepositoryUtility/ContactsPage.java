package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//img[@title='Create Contact...']")
	public WebElement CreateContactBtn;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	public WebElement HeaderMsg;

	public WebElement getCreateContactBtn() {
		return CreateContactBtn;
	}

	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}
	
	
	
	
}
