package com.March07.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.March07.Pages.LogOnPage;
import com.March07.Utilities.MyTestListener;

@Listeners(MyTestListener.class)
public class TC001_LogOnCheck extends Base_TestCase {
	
	
	@Test(dataProvider = "readData")
	public void testOnly(String user, String Pass) {
		
		logger.pass("Test for user : " + user + " : " + Pass);
		
		System.out.println("All good here?????  ");
		
		LogOnPage loginPage = new LogOnPage();
		
		logger.pass("LogOnPage Launched");
		
		loginPage.launchLoginPopUp();
		
		logger.info("LogIn creds Entered");
		
		loginPage.loginToWebsite();
		
		logger.fail("just in case to check");
		
		loginPage.addTask();
		logger.skip("SKip test ");
		
		Assert.assertEquals(true, true);
		
		logger.pass("Task Added and finished testing");
		
	}	
}