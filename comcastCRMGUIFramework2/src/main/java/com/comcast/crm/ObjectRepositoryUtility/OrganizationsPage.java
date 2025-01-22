package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	 WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgBtn;
	@FindBy(name="search_text")
	private WebElement searchedit;
	@FindBy(name="search_field")
	private WebElement searchDD;
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getCreateOrgBtn() {
		return CreateOrgBtn;
	}

	public WebElement getSearchedit() {
		return searchedit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
}
