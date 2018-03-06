package com.test.automation.uiAutomation.demoqa.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;

public class RegistrationPage extends TestBase{
	
	
	@FindBy(id = "user_login")
	WebElement userName;
	@FindBy(id = "user_email")
	WebElement userEmail;
	@FindBy(id = "signup_button")
	WebElement createAnAccount;
	
	public RegistrationPage(EventFiringWebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void registeration(String firstNametext, String lastNametext) {
		
		userName.sendKeys(firstNametext);
		userEmail.sendKeys(lastNametext);
		createAnAccount.click();
	}
}
