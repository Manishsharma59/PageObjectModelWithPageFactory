package com.test.automation.uiAutomation.demoqa.homepage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test002 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
	
		
		/*
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"customers\"]")).getText());
		driver.findElement(By.id("name_3_firstname")).sendKeys("Manis");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Sharma");
		driver.findElement(By.name("pie_submit")).click();*/
		
		 	String name = "Mannu";
			  ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
			  list.add("Ravi");//Adding object in arraylist  
			  list.add("Vijay");  
			  list.add("Ravi");  
			  list.add("Ajay");  
			  
			   System.out.println(list); 
			   while(!(list.contains(name))) {
				   System.out.println("Not Present");
				   list.add("Manish");
				   list.add("Mannu");
			   }
			   System.out.println("Present");
			 }  
}

