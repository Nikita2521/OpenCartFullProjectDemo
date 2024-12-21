package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement UserName;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	
	public void txtUserName(String username)
	{
		UserName.sendKeys(username);
	}
	
	public void Passsword(String txtpassword)
	{
		password.sendKeys(txtpassword);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
	
	
	

}
