package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class LoginPage
{

	@FindBy(name="username")
	private @Getter WebElement untxtbx;
	
	@FindBy(name="pwd")
	private @Getter WebElement pwdtxtbx;
	
	@FindBy(id="loginButton")
	private @Getter WebElement loginbtn;
	
	public LoginPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
}

