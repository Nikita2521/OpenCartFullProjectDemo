package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationClass;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("**Starting TC001_TC001_AccountRegistrationTest**");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account");
		hp.clickOnPegister();
		logger.info("Clicked on registration");
		
		AccountRegistrationClass regpahe = new AccountRegistrationClass(driver);
		logger.info("Providing customer details");
		regpahe.setFirstName(randomeString().toUpperCase());
		regpahe.setLirstName(randomeString().toUpperCase());
		regpahe.setEmail(randomeString()+"@gmail.com");
		regpahe.setTelephone(randomeNumber());
		
		String pass = randomeAlphaNumber();
		regpahe.setPassword(pass);
		regpahe.setConfirmPassword(pass);
		regpahe.setPrivacyPolicy();
		regpahe.clickContinue();
		logger.info("Validating expected message..");
		String conmsg = regpahe.getConfirmationMsg();
		
		if(conmsg.equals("Your Account Has Been Created!"))
		{
			assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("debug logs");
			assertTrue(false);
		}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		/* -- here hard assertion is there so if it fails it will not 
		 * go to the catch block so here we have to use normal if else condition
		Assert.assertEquals(conmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("debug logs");
			Assert.fail();
		}*/
		
		
		
		logger.info("Finish TC_001");
	}
	
	
	

}
