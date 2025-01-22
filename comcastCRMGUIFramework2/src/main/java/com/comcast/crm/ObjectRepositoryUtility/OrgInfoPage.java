package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

 WebDriver driver;
	public OrgInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement OrgHeaderText;

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	
}
