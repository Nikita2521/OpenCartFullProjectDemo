package testBase;

import java.io.FileReader;

import java.io.IOException;
import java.net.URL;
//import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //;oh4j
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public WebDriver driver;

public Logger logger; //for logging
public Properties p;
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	public void setup(String os,String browser) throws IOException
	{
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		//loading config.properties file
		System.out.println("hii niki ");
		
		
		logger= LogManager.getLogger(this.getClass()); //for logging
		
		
		//if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		//{
			System.out.println("remote");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setPlatform(Platform.WIN10);
			//os
			if(os.equalsIgnoreCase("windows"))
					{
				System.out.println("windows");
				capabilities.setPlatform(Platform.WIN11);
					}
			
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				System.out.println("linux");
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("no matching system");
			}
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome" :capabilities.setBrowserName("chrome"); System.out.println("chrome");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default : System.out.println("invalid browser name "); return;
			}
			System.out.println("remotw web");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			System.out.println("after remote web");
		//}
		
		/*if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{*/
		/*
		else {
			System.out.println("hii niki 3");
			switch(browser.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver(); System.out.println("hii niki 4");break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("invalid browser name "); return;
			}
			
		}*/
		/*
		switch(browser.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("invalid browser name "); return;
		}*/
		System.out.println("hii niki 5");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	public String randomeString()
	{
		String randome=RandomStringUtils.randomAlphabetic(5);
		return randome;
	}
	
	public String randomeNumber()
	{
		String randome=RandomStringUtils.randomNumeric(10);
		return randome;
	}
	
	public String randomeAlphaNumber()
	{
		String randome=RandomStringUtils.randomAlphabetic(3);
		String randome1=RandomStringUtils.randomNumeric(3);
		return (randome+"@"+randome1);
	}
	
	@AfterClass(groups= {"Sanity","Regression","Maseter"})
	public void tesrDown()
	{
		driver.quit();
	}

}
