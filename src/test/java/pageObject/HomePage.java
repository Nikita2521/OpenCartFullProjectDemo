package pageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement linklogin;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickOnPegister()
	{
		lnkRegister.click();
	}
	
	public void clickOnLogin()
	{
		linklogin.click();
	}
	
	
	
	
	

}
