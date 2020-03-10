package com.March07.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod; 
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.March07.Master.Master;
import com.March07.Utilities.Utilities;

public class Base_TestCase extends Master { 

	
	@BeforeSuite
	public void beforeSuiteSetUp() {
		
		initReporting();
		
		
	}
	
	
	@AfterSuite
	public void afterSuiteSetUp() {
		
		flushReport();
		
	}
	
	
	@BeforeMethod
	public void beforeMethodSetUp() {
		
		launchBrowserAndNavigate();
		
	}
	
	@AfterMethod
	public void afterMethodSetUp() {
		
		closeDriver();
	}
	
	
	@DataProvider
	public String[][] readData() throws IOException {
		
		return Utilities.readExcelData();
		
	}
		
}