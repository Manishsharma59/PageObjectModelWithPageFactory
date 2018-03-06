package com.test.automation.uiAutomation.demoqa.uiActions;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ScrollPaneLayout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomeLoanPage extends TestBase{
	
	@FindBy(xpath = "//a[@class='btn blue btn_vd scg-btn ng-scope']")
	WebElement skipAndContinueLnk;
	
	@FindBy(xpath = "//*[@id='check-eligibility-page']/div[4]/div/div[1]/form/div[1]/div/div/div[2]/div/div/div/button/span[1][@class='filter-option pull-left']")
	WebElement residencyStatus;
	
	@FindBy(xpath = "//input[starts-with(@name,'1519')]")
	WebElement cityName;
	
	@FindBy(xpath = "//*[@id=\"city-map-icon\"]/img[@src=\"assets/images/calendar.svg\"]")
	List<WebElement> calenderIcon;
	
	@FindBy(xpath = "//*[contains(@id,'datepicker')]/button/span")
	List<WebElement> yearList;
	
	
	@FindBy(name = "registeredMobile")
	WebElement registeredMobile;
	
	@FindBy(xpath = "//*[@id='check-eligibility-page']/div[4]/div/div[1]/form/div[1]/div/div/div[6]/div/div/div/button/span[1][@class='filter-option pull-left']")
	WebElement typeOfLoan;
	
	@FindBy(xpath = "//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[10]/div/div/div/button")
	WebElement typeOfEmployment;
	
	@FindBy(xpath = "//*[@id='check-eligibility-page']/div[4]/div/div[1]/form/div[1]/div/div/div[7]/div/div/div/div/button/span[1][@class='filter-option pull-left']")
	WebElement purposeOfLoan;
	
	
	@FindBy(xpath = "//*[contains(@id,\"1519\")]")//
	List<WebElement> companyName;
	
	@FindBy(xpath = "//*[@id=\"applicantGrossMonthlySalary\"]")
	WebElement grossSalary;
	
	@FindBy(xpath = "//*[@id=\"applicantAnnualBonus\"]")
	WebElement bonus;
	
	@FindBy(xpath = "//*[@id=\"applicantEMIPerMonth\"]")
	WebElement currentEMI;
	
	@FindBy(xpath = "//*[@id=\"applicantMonthlyTakeHomeSalary\"]")
	WebElement takeHomeSalary;
	
	@FindBy(xpath = "//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[2]/div/div[2]/div/button/span[1]")
	WebElement yearOfJoining;
	
	@FindBy(xpath = "//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[2]/div/div[3]/div/button/span[1]")
	WebElement monthOfJoining;
	
	@FindBy(xpath = "//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[3]/div[2]/div/div/button/span[1]")
	WebElement retireAge;
	
	@FindBy(xpath = "//*[@id=\"grossTurnOverCurrentYear1\"]")
	WebElement grossTurnOverCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"netProfit1\"]")
	WebElement netProfitCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"directorRenumeration1\"]")
	WebElement directorRenumerationCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"otherIncome1\"]")
	WebElement otherIncomeCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"applicantCurrentYearTax\"]")
	WebElement applicantCurrentYearTax;
	
	@FindBy(xpath = "//*[@id=\"existingMonthlyObligations\"]")
	WebElement existingMonthlyObligations;
	
	@FindBy(xpath = "//*[@id=\"grossProfit1\"]")
	WebElement grossProfitCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"depreciation1\"]")
	WebElement depreciationCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"rentalIncome1\"]")
	WebElement rentalIncomeCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"ccOdInterest1\"]")
	WebElement ccOdInterestCurrentYear;
	
	@FindBy(xpath = "//*[@id=\"estimatedPropertyValue1\"]")
	WebElement estimatedPropertyValue;
	
	@FindBy(xpath = "//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[1]/div/div/button/span[1]")
	WebElement businessProfile;
	
	@FindBy(xpath = "//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[2]/div/div[2]/div/button/span[1]")
	WebElement startYearOfBussiness;
	
	@FindBy(xpath = "//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[2]/div/div[3]/div/button/span[1]")
	WebElement startMonthOfBussiness;
	
	@FindBy(id = "eligibility-btn")
	WebElement eligibilityBtn;
	
	
	HomeLoanPage(EventFiringWebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSkip() throws InterruptedException {
		
		Thread.sleep(10000);
		scrollBy("0","200");
		
		skipAndContinueLnk.click();
		
		
	}
	
	
public void selectResidencyStatus(int index) throws InterruptedException {
	Thread.sleep(10000);
	waitForElement(driver, 120, residencyStatus);
	residencyStatus.click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//li[@data-original-index='"+index+"']")).click();
	}



public void selectDOB(String date) throws InterruptedException {
	Thread.sleep(10000);
	
	waitForElement(driver, 120, calenderIcon.get(2));
	System.out.println(calenderIcon.get(2));
	calenderIcon.get(2).click();
	String [] dateArray = date.split("/");
	 String year = dateArray[2];
	 String month = dateArray[1];
	 String dateindigit = dateArray[0];
	 
	 System.out.println(yearList.size());
	 ArrayList<String> dateTextList = new ArrayList<String>();
	 for(int i =0;i<yearList.size();i++) {
		 dateTextList.add(yearList.get(i).getText().toString().trim());
	 }
	
	 System.out.println(year);
	 System.out.println(dateTextList);
	
	while(!(dateTextList.contains(year))) {
		System.out.println(dateTextList);
		driver.findElement(By.xpath("//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[3]/div[1]/div[2]/ul/li[1]/div/table/thead/tr/th[1]/button")).click();
	 for(int i =0;i<yearList.size();i++) {
		 dateTextList.add(yearList.get(i).getText().toString().trim());
	 }
	 System.out.println(dateTextList);
	}
	 driver.findElement(By.xpath("//span[text()='"+year+"']")).click();
	 driver.findElement(By.xpath("//span[text()='"+month+"']")).click();
	 driver.findElement(By.xpath("//span[text()='"+dateindigit+"']")).click();
	Thread.sleep(6000);
	
	}

public void selectTypeOfLoan(int index) throws InterruptedException {
	Thread.sleep(10000);
	scrollBy("0","300");
	typeOfLoan.click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div[1]/form/div[1]/div/div/div[6]/div/div/div/div/ul/li["+index+"]/a/span[1]")).click();
	}



public void selectPurposeOfLoan(int index) throws InterruptedException {
	Thread.sleep(10000);
	purposeOfLoan.click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div[1]/form/div[1]/div/div/div[7]/div/div/div/div/div/ul/li["+index+"]/a/span[1]")).click();
	}

public void selectTypeOfEmployment(int index,String companyNametext,String grossSalaryInt,String bonusInt,String currentEMIInt, String takeHomeSalaryText,String yearOfJoiningText,String monthOfJoiningText,String retireAgeText,
		String businessProfileTxt,String yearOfJoiningTxt1,String monthOfJoiningTxt1,
		String grossTurnOverCurrentYeartxt,String netProfitCurrentYearTxt,String directorRenumerationCurrentYearTxt,
		String otherIncomeCurrentYearTxt,String applicantCurrentYearTaxTxt,String existingMonthlyObligationsTxt,
		String grossProfitCurrentYearTxt,String depreciationCurrentYearTxt,String rentalIncomeCurrentYearTxt,
		String ccOdInterestCurrentYearTxt,String estimatedPropertyValueTxt) throws InterruptedException {
	Thread.sleep(10000);
	scrollBy("0","300");
	typeOfEmployment.click();
	Thread.sleep(6000);
	
	
	if(index==2) {
	driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div[1]/form/div[1]/div/div/div[10]/div/div/div/div/ul/li["+index+"]/a")).click();
	salariedPersonDetails(companyNametext, grossSalaryInt, bonusInt, currentEMIInt, takeHomeSalaryText, yearOfJoiningText, monthOfJoiningText, retireAgeText);
	
	}
	
	if(index==3) {
		driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div[1]/form/div[1]/div/div/div[10]/div/div/div/div/ul/li["+index+"]/a")).click();
		selfEmployed(businessProfileTxt, yearOfJoiningTxt1, monthOfJoiningTxt1, grossTurnOverCurrentYeartxt, netProfitCurrentYearTxt, directorRenumerationCurrentYearTxt, otherIncomeCurrentYearTxt, applicantCurrentYearTaxTxt, existingMonthlyObligationsTxt, grossProfitCurrentYearTxt, depreciationCurrentYearTxt, rentalIncomeCurrentYearTxt, ccOdInterestCurrentYearTxt,estimatedPropertyValueTxt);
	}
	}

public void salariedPersonDetails(String companyNametext,String grossSalaryInt,String bonusInt,String currentEMIInt, String takeHomeSalaryText,String yearOfJoiningText,String monthOfJoiningText,String retireAgeText) {
	companyName.get(1).sendKeys(companyNametext);
	grossSalary.sendKeys(grossSalaryInt);
	bonus.sendKeys(bonusInt);
	currentEMI.sendKeys(currentEMIInt);
	takeHomeSalary.sendKeys(takeHomeSalaryText);
	yearOfJoining.click();
	driver.findElement(By.xpath("//*[text()='"+yearOfJoiningText+"']")).click();
	monthOfJoining.click();
	driver.findElement(By.xpath("//*[text()='"+monthOfJoiningText+"']")).click();
	retireAge.click();
	driver.findElement(By.xpath("//*[text()='"+retireAgeText+"']")).click();
}

public void selfEmployed(String businessProfileTxt,String yearOfJoiningTxt1,String monthOfJoiningTxt1,
		String grossTurnOverCurrentYeartxt,String netProfitCurrentYearTxt,String directorRenumerationCurrentYearTxt,
		String otherIncomeCurrentYearTxt,String applicantCurrentYearTaxTxt,String existingMonthlyObligationsTxt,
		String grossProfitCurrentYearTxt,String depreciationCurrentYearTxt,String rentalIncomeCurrentYearTxt,
		String ccOdInterestCurrentYearTxt,String estimatedPropertyValueTxt ) {
	businessProfile.click();
	driver.findElement(By.xpath("//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[1]/div/div/div/ul/li/a/span[text()='"+businessProfileTxt+"']")).click();
	yearOfJoining.click();
	driver.findElement(By.xpath(" //*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[2]/div/div[2]/div/div/ul/li/a/span[text()='"+yearOfJoiningTxt1+"']")).click();
	monthOfJoining.click();
	driver.findElement(By.xpath("//*[@id=\"check-eligibility-page\"]/div[4]/div/div[1]/form/div[1]/div/div/div[11]/div[1]/div[2]/div/div[3]/div/div/ul/li/a/span[text()='"+monthOfJoiningTxt1+"']")).click();
	grossTurnOverCurrentYear.sendKeys(grossTurnOverCurrentYeartxt);
	netProfitCurrentYear.sendKeys(netProfitCurrentYearTxt);
	directorRenumerationCurrentYear.sendKeys(directorRenumerationCurrentYearTxt);
	otherIncomeCurrentYear.sendKeys(otherIncomeCurrentYearTxt);
	applicantCurrentYearTax.sendKeys(applicantCurrentYearTaxTxt);
	existingMonthlyObligations.sendKeys(existingMonthlyObligationsTxt);
	grossProfitCurrentYear.sendKeys(grossProfitCurrentYearTxt);
	depreciationCurrentYear.sendKeys(depreciationCurrentYearTxt);
	rentalIncomeCurrentYear.sendKeys(rentalIncomeCurrentYearTxt);
	ccOdInterestCurrentYear.sendKeys(ccOdInterestCurrentYearTxt);
	estimatedPropertyValue.sendKeys(estimatedPropertyValueTxt);
	
	
	
	
}

public void checkEligibility(int index,String city,String date,String mobNumber,int loanTypeIndex,int purposeOfLoanIndxe,int empTypeIndex,String companyNametext,String grossSalaryInt,String bonusInt,String currentEMIInt, String takeHomeSalaryText,String yearOfJoiningText,String monthOfJoiningText,String retireAgeText,
		String businessProfileTxt,String yearOfJoiningTxt1,String monthOfJoiningTxt1,
		String grossTurnOverCurrentYeartxt,String netProfitCurrentYearTxt,String directorRenumerationCurrentYearTxt,
		String otherIncomeCurrentYearTxt,String applicantCurrentYearTaxTxt,String existingMonthlyObligationsTxt,
		String grossProfitCurrentYearTxt,String depreciationCurrentYearTxt,String rentalIncomeCurrentYearTxt,
		String ccOdInterestCurrentYearTxt,String estimatedPropertyValueTxt
		) throws InterruptedException {
	System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(), "ICICI Bank");
	selectResidencyStatus(index);
	cityName.sendKeys(city);
	selectDOB(date);
	registeredMobile.sendKeys(mobNumber);
	selectTypeOfLoan(loanTypeIndex);
	selectPurposeOfLoan(purposeOfLoanIndxe);
	selectTypeOfEmployment(empTypeIndex, companyNametext, grossSalaryInt, bonusInt, currentEMIInt, takeHomeSalaryText, yearOfJoiningText, monthOfJoiningText, retireAgeText,businessProfileTxt, yearOfJoiningTxt1, monthOfJoiningTxt1, grossTurnOverCurrentYeartxt, netProfitCurrentYearTxt, directorRenumerationCurrentYearTxt, otherIncomeCurrentYearTxt, applicantCurrentYearTaxTxt, existingMonthlyObligationsTxt, grossProfitCurrentYearTxt, depreciationCurrentYearTxt, rentalIncomeCurrentYearTxt, ccOdInterestCurrentYearTxt,estimatedPropertyValueTxt);
	scrollBy("0", "300");
	eligibilityBtn.click();
}

public String getTitleHomepage() {
	return driver.getTitle();
}
	
}
