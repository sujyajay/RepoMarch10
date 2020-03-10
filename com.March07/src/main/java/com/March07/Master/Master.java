package com.March07.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Master implements MyOrgInterface {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Properties prop;
	
	
	public Master() {
		
		String globalVarFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\GlobalVariables.properties";
		prop = new Properties();
		try {
			prop.load(new FileInputStream(globalVarFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void launchBrowserAndNavigate() {
		
		String url = prop.getProperty("url"); 
		String browser = prop.getProperty("browser");
		
		switch(browser) {
		
		case "chrome" :;
		
		case "FF" :;
		
		default: 
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Batman\\Desktop\\POC-DockerContainer\\com.March07\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		 //Wait wait = new FluentWait(driver);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(url);		
	}
	
	
	public static void closeDriver() {
		
		driver.quit();		
		
	}
	
	
	public static void initReporting() {
		String htmlReportPath = System.getProperty("user.dir") + "\\Reports\\ExtentHTMLReport.html";
		html = new ExtentHtmlReporter(htmlReportPath);
		extent = new ExtentReports();
		extent.attachReporter(html);
		logger = extent.createTest("Reporting Starts here:");
		logger.pass("Reporting first Step: ");				
	}
	
	
	public static void flushReport() {
		
		extent.flush();
		
	}

	@Override
	public void mySample() {
		// TODO Auto-generated method stub	
		
	}	

}












