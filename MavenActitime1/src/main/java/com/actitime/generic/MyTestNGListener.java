package com.actitime.generic;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestNGListener implements ITestListener
{

	public static int executionCount, passCount, failCount,skipCount=0;
	
    //@Override		
    public void onStart(ITestContext context) 
    {					
        	Reporter.log("Test suite Execution starts"+new Date(), true);			
        		
    }		

    //@Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    {					
        		
    }		

   // @Override		
    public void onTestFailure(ITestResult result) 
    {					
        	failCount++;
        	Reporter.log(result.getName()+"Test Fail", true);
        	
        	TakesScreenshot ts=(TakesScreenshot)BaseLib.driver;
        	File srcfile=ts.getScreenshotAs(OutputType.FILE);
        	
        	File destFile=new File("./screenshot/"+result.getName()+".png");
        	
        	try 
        	{
			Files.copy(srcfile, destFile);
			} 
        	catch (Exception e) 
        	{
        		e.printStackTrace();
			}
        	
    }		

    //@Override		
    public void onTestSkipped(ITestResult result) 
    {					
       		skipCount++;
       		Reporter.log(result.getName()+"script is skipped", true);
        		
    }		

   // @Override		
    public void onTestStart(ITestResult result)
    {					
        executionCount++;
        Reporter.log(result.getName()+"Script execution Start"+new Date(), true);
        		
    }		
    //@Override		
    public void onTestSuccess(ITestResult result)
    {					
       passCount++;
       Reporter.log(result.getName()+"Script is passed"+new Date(), true);
    	
    }
    //@Override		
    public void onFinish(ITestContext context)
	{					
       Reporter.log("Suite Execution end"+new Date(), true); 
       Reporter.log("Total Scripts Executed:"+executionCount, true);
       Reporter.log("Total Scripts passed:"+passCount, true);
       Reporter.log("Total Scripts fail:"+failCount, true);
       Reporter.log("Total Scripts Skipped:"+skipCount, true);
    }		

}		

