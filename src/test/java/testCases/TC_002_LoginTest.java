package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("**Starting TC_002_LoginTest**");
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickOnLogin();
		//login page
		LoginPage lp = new LoginPage(driver);
		lp.txtUserName(p.getProperty("email"));
		lp.Passsword(p.getProperty("pass"));
		lp.clickLogin();
		
		//accountpage
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetPage=myacc.isMyAccountExists();
		//assertEquals(targetPage, true);
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			fail();
		}
	}

}
