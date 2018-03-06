package com.test.automation.uiAutomation.demoqa.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;

public class Privilege extends TestBase{
	
	
	@FindBy(linkText = "Advantage")
	WebElement advantage;
	
	Privilege(EventFiringWebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Advantage clickOnAdvantage() {
		advantage.click();
		return new Advantage(driver);
	}
	
}
