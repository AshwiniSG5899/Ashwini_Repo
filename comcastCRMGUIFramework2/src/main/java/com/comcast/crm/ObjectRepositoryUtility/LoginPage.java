package com.comcast.crm.ObjectRepositoryUtility;
/**
 * 
 * @author QSP-Ashtra
 * contains login page elements and business libraries like login()
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericWebDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	
	 WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(name="user_name")
	private WebElement usernameEdit;
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	/**
	 * login to application based on username, password and url
	 * @param url
	 * @param username
	 * @param password
	 */
	//providing action
	public void LoginToApp(String url,String username,String password) {
		waitForPageLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		LoginBtn.click();
		
	}
	
	
	
	
	
	
	
}
