package com.actitime.feature;

import org.openqa.selenium.WebDriver;

import com.actitime.pageobject.LoginPage;

public class LoginFeature
{

	WebDriver driver;
	LoginPage lp;
	
	
	public LoginFeature(WebDriver driver)
	{
		this.driver=driver;
		lp= new LoginPage(driver);
		
	}
	//this is login code
	public void login(String username, String password)
	
	{
		lp.getUntxtbx().sendKeys(username);
		lp.getPwdtxtbx().sendKeys(password);
		lp.getLoginbtn().click();
		
	}
	
	
}
