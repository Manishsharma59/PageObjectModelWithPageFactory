package com.test.automation.uiAutomation.demoqa.uiActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.automation.uiAutomation.testBase.TestBase;

public class Advantage extends TestBase{
	
	@FindBy(xpath = "//*[@id='main']/div[4]/ul/li[1]/a/span[text()='Apply Online']")
	WebElement applyOnline;
	
	
	Advantage(EventFiringWebDriver driver){
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public ApplyOnline clickOnApplyOnline() throws InterruptedException {
		Thread.sleep(6000);
		scrollBy("0","850");
		
		/*JavascriptExecutor oJse = (JavascriptExecutor) driver;
		oJse.executeScript("window.scrollBy(0,600)", " ");*/
		applyOnline.click();
		return new ApplyOnline(driver);
	}

}
