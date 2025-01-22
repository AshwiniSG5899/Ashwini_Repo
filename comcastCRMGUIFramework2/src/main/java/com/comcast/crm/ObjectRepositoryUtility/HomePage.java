package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	

	public HomePage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	@FindBy(linkText="More")
	private WebElement moreLink;
	@FindBy(linkText="Campaigns")
	private WebElement compaignLink;
	@FindBy(linkText="Products")
	private WebElement productLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getCompaignLink() {
		return compaignLink;
	}
	
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	public WebElement getProductLink() {
		return productLink;
	}
	public void navigateToCompaign()
	{
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		compaignLink.click();
	}
	public void Logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		SignOutLink.click();
		
	}
	
	
	
}
