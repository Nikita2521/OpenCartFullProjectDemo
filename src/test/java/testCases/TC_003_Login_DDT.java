package testCases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Login_DDT extends BaseClass {
	
	
		@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven") //getting data provider from different class
		public void verify_login_DDT(String email, String Pass, String expectedR)
		{
			logger.info("**Starting TC_003_LoginDDTTest**");
			try {
			//homepage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickOnLogin();
			//login page
			LoginPage lp = new LoginPage(driver);
			logger.info("**enter emaiil");
			lp.txtUserName(email);
			lp.Passsword(Pass);
			lp.clickLogin();
			
			//accountpage
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetPage=myacc.isMyAccountExists();
			
			//data is valid -- login success -- test pass --logout
			//                 login failed -- test fail
			
			//data is invalid -- login success -- test fail --logout
			//                   login failed -- test pass
			if(expectedR.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					myacc.linkLogout();
			         assertTrue(true);
			         
				}
				else
				{
					assertTrue(false);
				}
			}
			
			if(expectedR.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					myacc.linkLogout();
			         assertTrue(false);
			         
				}
				else
				{
					 assertTrue(true);
				}
			
			
		}
			}
			catch(Exception e)
			{
				fail();
			}
			
			logger.info("**Finish TC_003_LoginDDTTest**");
		}
}

	

	
