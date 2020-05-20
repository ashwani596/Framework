package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseLib 
{
    public static WebDriver driver;
    
	@BeforeMethod
	
	@Parameters({"browserName", "baseurl"})
	public void precond(String browserName, String baseurl)
	{
		driver=BrowserFactory.Launch(browserName, baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseurl);
		Reporter.log("URL is Navigated", true);
		
	}
	
	@AfterMethod
	public void postcond()
	{
		driver.quit();
		Reporter.log("Browser closed", true);
	}
	
	
}
