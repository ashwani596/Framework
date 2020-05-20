package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.feature.LoginFeature;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class LoginTest extends BaseLib
{

	@Test
	
	public void ValidLogin()
	{
		
		     ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
		     String username = eu.readData("Sheet1", 1, 1);
		     String password = eu.readData("Sheet1", 1, 2);
		     
		     LoginFeature lf=new LoginFeature(driver);
		     lf.login(username, password);
		
		
	}
	
	
}
