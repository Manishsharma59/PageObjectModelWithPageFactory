package com.test.automation.uiAutomation.demoqa.homepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.demoqa.uiActions.Advantage;
import com.test.automation.uiAutomation.demoqa.uiActions.ApplyOnline;
import com.test.automation.uiAutomation.demoqa.uiActions.HomeLoanPage;
import com.test.automation.uiAutomation.demoqa.uiActions.Homepage;
import com.test.automation.uiAutomation.demoqa.uiActions.Privilege;
import com.test.automation.uiAutomation.demoqa.uiActions.RegistrationPage;
import com.test.automation.uiAutomation.testBase.TestBase;


public class Test001 extends TestBase{
	
	Homepage homepage;
	RegistrationPage registrationPage;
	
	@BeforeClass
	public void setUp() throws IOException, AWTException {
		init();
		
	}
	
	@Test
	public void registrationTest() throws AWTException, InterruptedException {
		
		homepage = new Homepage(driver);
		Privilege privilege= homepage.clickOnPrivilege();
		Advantage advantage = privilege.clickOnAdvantage();
		ApplyOnline applyOnline = advantage.clickOnApplyOnline();
		HomeLoanPage homeLoanPage = applyOnline.clickOnHomeLoan();
		homeLoanPage.clickOnSkip();
		homeLoanPage.checkEligibility(1, "Noida","05/Jan/1990", "1237209595",2,3,2,"XAVIENT SOFTWARE SOLUTIONS (INDIA) PRIVATE LIMITED","80000","50000","0","75000","2018","Jan","60","Trader","2017","Feb","100000","1000","10","0","200","5","25","5","","10","100");
		
	}
	
	@Test
	public void applyForHomeLoanFromHomePage() throws AWTException, InterruptedException {
		
		homepage = new Homepage(driver);
		System.out.println(homepage.getTitleHomepage());
		Assert.assertEquals(homepage.getTitleHomepage(), "Personal Banking, Online Banking Services - ICICI Bank");
		homepage.applyOnline();
		HomeLoanPage homeLoanPage = homepage.clickOnHomeLoanLnk();
		homeLoanPage.checkEligibility(1, "Noida","05/Jan/1990", "1237209595",2,3,3,
				"XAVIENT SOFTWARE SOLUTIONS (INDIA) PRIVATE LIMITED","80000","50000",
				"0","75000","2018","Jan","60","Trader","2017","Dec","100000","10","10",
				"10","200","5","25","5","15","10","100");
		
	}
	
	

}
