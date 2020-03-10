package com.March07.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.March07.Master.Master;

public class LogOnPage extends Master{
		
	
	@FindBy(xpath ="//ul[@class='W9ktc']//li//a[text()='Login']") WebElement loginButton;
	@FindBy(id ="email") WebElement loginIDField;
	@FindBy(id ="password") WebElement loginPassField;
	@FindBy(xpath ="//button[@class='submit_btn ist_button ist_button_red sel_login']") WebElement loginSubmitButton;
	
	public String loginID = prop.getProperty("username");
	public String passCode = prop.getProperty("password");
	
	@FindBy(xpath="//a[@class='action']") WebElement addTask;
	@FindBy(xpath="//button[@class='item_editor_submit ist_button ist_button_red']") WebElement taskName;
	@FindBy(xpath="//button[@type='submit']") WebElement taskSubmit;
	
	
	public LogOnPage() {
		
		PageFactory.initElements(driver, this);		
		
	}
	
	
	public void launchLoginPopUp() {
		
		loginButton.click();
		
	}
	
	
	public void loginToWebsite() {
		

		driver.switchTo().frame(0);		
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginIDField.sendKeys(loginID);
		loginPassField.sendKeys(passCode);
		loginSubmitButton.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SoftAssert sa = new SoftAssert();		
	}
	
	
	public void addTask() {
		
		addTask.click();
		taskName.sendKeys("First Task");
		taskSubmit.click();		
	}
	
		
}