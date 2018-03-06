package com.test.automation.uiAutomation.demoqa.uiActions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;

public class ApplyOnline extends TestBase {
	
	
	@FindBy(linkText = "Home Loan")
	WebElement homeLoanLnk;
	
	ApplyOnline(EventFiringWebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public HomeLoanPage clickOnHomeLoan() {
		scrollBy("0","550");
		homeLoanLnk.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String obj : allWindows) {
			if(!(obj.equals(parentWindow))) {
				
				driver.switchTo().window(obj);
				break;
			}
		}
		
		return new HomeLoanPage(driver);
	}
}
