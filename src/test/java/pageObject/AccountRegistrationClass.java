package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationClass extends BasePage {
	
	public AccountRegistrationClass(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	public  void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public  void setLirstName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public  void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public  void setTelephone(String telephoen)
	{
		txtTelephone.sendKeys(telephoen);
	}
	public  void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public  void setConfirmPassword(String conpassword)
	{
		txtConfirmPassword.sendKeys(conpassword);
	}
	
	public  void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		//sol 1
		btnContinue.click();
		
		//sol2
		//btnContinue.submit();
		
		//sol3
		//Actions act = new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	

}
