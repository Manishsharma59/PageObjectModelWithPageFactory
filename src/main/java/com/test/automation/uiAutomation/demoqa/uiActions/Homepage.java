package com.test.automation.uiAutomation.demoqa.uiActions;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;
	
public class Homepage extends TestBase {

	@FindBy(linkText = "Sign up")
	WebElement signup;
	
	
	@FindBy(linkText = "Privilege")
	WebElement privilege;
	
	@FindBy(id = "push-modal-close")
	WebElement pushModalClose;
	
	@FindBy(xpath = "//div/div/div[@id=\"Loan\"]")
	WebElement applyOnline;
	
	@FindBy(xpath = "//*[@id=\"Loan_mod\"]/div[2]/div[3]/table/tbody/tr/td/a/img")
	WebElement homeLoanLnk;
	
	
	public Homepage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pushModalClose();
	}
	
	
	public RegistrationPage clickOnRegistration() {
		signup.click();
		return new RegistrationPage(driver);
	}
	
	
	public Privilege clickOnPrivilege() {
		pushModalClose();
		privilege.click();
		return new Privilege(driver);
	}
	
	public void pushModalClose() {
		pushModalClose.click();
	}
	
	public void applyOnline() {
		applyOnline.click();
	}
	
	public HomeLoanPage clickOnHomeLoanLnk() {
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
	
	public String getTitleHomepage() {
		return driver.getTitle();
	}
	
	}


