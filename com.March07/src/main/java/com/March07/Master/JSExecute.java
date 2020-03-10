package com.March07.Master;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecute implements MyOrgInterface{

	
	@Test
	public void myTest() {
		
		mySample();
		
	}
	
	@Override
	public void mySample() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Batman\\Desktop\\POC-DockerContainer\\com.March07\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
	driver.get("https://salesforce.com");
	driver.navigate().refresh();
	driver.navigate().to("https://test.salesforce.com");

		WebElement tryNow = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-nav salesforce-sans-regular    ']"));
		String color = "rgb(0,300,0)";
		myJSExecutor(tryNow, driver, color);
	
	}
	
	
	public void myJSExecutor(WebElement tryNow, WebDriver driver, String color) {
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.backgroundColor", tryNow);
			String bgcolor  = tryNow.getCssValue("backgroundColor");
			
			for(int i=0;i<500;i++) {
			js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  tryNow);
			js.executeScript("arguments[0].style.backgroundColor = '"+bgcolor+"'",  tryNow);
			}
			}
		
	}
