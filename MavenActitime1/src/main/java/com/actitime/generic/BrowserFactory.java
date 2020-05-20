package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserFactory
{
    static WebDriver driver;
	public static WebDriver Launch(String browserName, String baseurl)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Chrome Browser is launch", true);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			driver=new FirefoxDriver();
			Reporter.log("Firefox Browser is Luanch", true);
		}
		
		
		return driver;
		
		
	}
	
}
