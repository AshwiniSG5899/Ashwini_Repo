package practice.HomePageTest;
/**
 * test class for contact module
 * @author QSP-Ashtra
 */

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.baseClassUtility.BaseClass;

public class SearchContactTest extends BaseClass{

	@Test
	public void SearchcontactTest()
	{
	LoginPage lp=new LoginPage(driver);
	lp.LoginToApp(null, null, null);
	}
}
