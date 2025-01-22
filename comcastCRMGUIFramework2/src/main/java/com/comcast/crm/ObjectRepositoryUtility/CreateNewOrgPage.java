package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrgPage {
	 WebDriver driver;
	public CreateNewOrgPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement OrgnameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(id="phone")
	private WebElement phoneEdit;
	
	

	public WebElement getOrgnameEdit() {
		return OrgnameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}
	
	public WebElement getPhoneEdit() {
		return phoneEdit;
	}

	public void createOrg(String OrgName)
	{
		OrgnameEdit.sendKeys(OrgName);
		saveBtn.click();
	}
	public void createOrg(String OrgName,String industry)
	{
		OrgnameEdit.sendKeys(OrgName);
		Select sel=new Select(industryDD);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	
	
	
	

}
