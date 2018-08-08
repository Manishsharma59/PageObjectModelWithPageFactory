package com.test.automation.uiAutomation.homepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.customListner.Retry;
import com.test.automation.uiAutomation.customListner.WebEventListener;

@Listeners(com.test.automation.uiAutomation.customListner.Listener.class)
public class WebTableHandling{
	public static final Logger log = Logger.getLogger(Retry.class.getName());
	public WebDriver dr;
	public EventFiringWebDriver driver;
	public WebEventListener event;
	public ExtentReports extent;
	public ExtentTest test;
	public ITestResult result;
	public Properties prop = new Properties();
	
	@BeforeMethod//Extent Reports implementation before method call
	public void beforeMethod(Method method) {
		extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/test/automation/uiAutomation/report/test"+new SimpleDateFormat("dd_MM_yyyy_mm_ss").format(Calendar.getInstance().getTime())+".html",false);
		test = extent.startTest(method.getName());
		test.log(LogStatus.INFO, method.getName()+" Test Started");
		}
	//After method getResult
	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}
	
	@AfterClass(alwaysRun = true)
	public void endTest() {
		test.log(LogStatus.INFO, "Browser closed");
		extent.endTest(test);
		extent.flush();
		driver.quit();
	}
	
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName()+" test passed");
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName()+" test skipped "+ result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			
			test.log(LogStatus.ERROR, result.getName()+" test is failed "+result.getThrowable());
			test.log(LogStatus.FAIL, test.addScreenCapture(errorScreenshotPath()));
		}
		
		else if(result.getStatus()==ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName()+" test started ");
		}
	}
	
	public String errorScreenshotPath() {
		File destFile = null;
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String path = new File(System.getProperty("user.dir")).getAbsolutePath()+"src\\main\\java\\com\\test\\automation\\uiAutomation\\screenshot\\";
			destFile = new File(path+"_"+new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(Calendar.getInstance().getTime())+".png");
		
		FileUtils.copyFile(srcFile, destFile);
		}catch(IOException e) {e.printStackTrace();}
		
		return destFile.toString();
	}
	
	public void init() throws AWTException, FileNotFoundException, IOException {
			
			//Configure Properties file
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\uiAutomation\\config\\config.properties")));
			System.out.println(prop.getProperty("url"));
			//Configure log4j
				PropertyConfigurator.configure("log4j.properties");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\msharma13\\eclipse-workspace\\PageObjectWithPageFactoryFramework-master\\drivers\\chromedriver.exe");
				
				//WebdriverEventListener registration with EventfiringWebDriver 
				dr = new ChromeDriver();
				driver = new EventFiringWebDriver(dr);
				event = new WebEventListener();
				driver.register(event);
				Robot robo = new Robot();
				robo.keyPress(KeyEvent.VK_WINDOWS);
				robo.keyPress(KeyEvent.VK_UP);
				robo.keyRelease(KeyEvent.VK_WINDOWS);
				robo.keyRelease(KeyEvent.VK_UP);
				
				driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");
				
	}

	
	@Test(retryAnalyzer=Retry.class)
	public void testMethod1() throws InterruptedException, AWTException, FileNotFoundException, IOException {
		
		init();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println(rows.size());
		test.log(LogStatus.INFO, "Row Size - "+rows.size());
		List<WebElement> headerColumn = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println(headerColumn.size());
			for(int r = 1;r<=rows.size();r++)	{			
				
			 WebElement ele = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td[1]"));
			 
			 String cellData = ele.getText();
			System.out.println(r+" "+"1"+" "+cellData);
			if(cellData.equals("Titan Company")) { 
				try {
			scrollIntoView(driver,ele);
			test.log(LogStatus.INFO, "Clicked on Kwality");
			Assert.assertEquals(true, true, "Kwality finds sucessfully");
			//ExplicitlyWait
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			driver.findElement(By.linkText(cellData)).click();
			driver.navigate().back();
				}catch(Exception e) {e.printStackTrace();}
			}
				
			}
		}
	
	public  void scrollIntoView(EventFiringWebDriver driver, WebElement element) {
		JavascriptExecutor ojse = (JavascriptExecutor) driver;
		ojse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
		}
		


