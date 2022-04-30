package com.ibm.FST_TestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity_9 {
  
	private FirefoxDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		driver = new FirefoxDriver();
		Reporter.log("Starting Test |");
		
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Opened Browser |");
		Reporter.log("Page title is " + driver.getTitle() + " |");
	}
	
	@BeforeMethod
	public void backToDefault() {
		
		Reporter.log("Test Case Setup started |");
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void simpleAlertTestCase() {
		
		Reporter.log("simpleAlertTestCase() started |");
		
		driver.findElement(By.id("simple")).click();
		Reporter.log("Simple Alert opened |");
		
		Alert simpleAlert =driver.switchTo().alert();
		Reporter.log("Switched foucs to alert |");
		
		String alertMsg=simpleAlert.getText();
		System.out.println("Test on simple alert box :"+alertMsg);
		Assert.assertEquals("This is a JavaScript Alert!", alertMsg);
		
		simpleAlert .accept();
		Reporter.log("Alert closed |");
		Reporter.log("Test case ended |");
	}
	
	@Test
	public void confirmAlertTestCase() {
		
        Reporter.log("confirmAlertTestCase() started |");
		
		driver.findElement(By.id("confirm")).click();
		Reporter.log("Confirm Alert opened |");
		
		Alert confirmAlert  =driver.switchTo().alert();
		Reporter.log("Switched foucs to alert |");
		
		String alertMsg=confirmAlert.getText();
		System.out.println("Test on confirm alert box :"+alertMsg);
		Assert.assertEquals("This is a JavaScript Confirmation!", alertMsg);
		
		confirmAlert .accept();
		Reporter.log("Alert closed |");
		Reporter.log("Test case ended |");
		
		
		
	}
	
	@Test
	public void promptAlertTestCase() {
		
        Reporter.log("promptAlertTestCase() started |");
		
		driver.findElement(By.id("prompt")).click();
		Reporter.log("Prompt Alert opened |");
		
		Alert promptAlert  =driver.switchTo().alert();
		Reporter.log("Switched foucs to alert |");
		
		String alertMsg=promptAlert.getText();
		System.out.println("Test on prompt alert box :"+alertMsg);
		Assert.assertEquals("This is a JavaScript Prompt!", alertMsg);
		
		promptAlert.sendKeys("Awesome!");
        Reporter.log("Text entered in prompt alert |");
		
        promptAlert .accept();
		Reporter.log("Alert closed |");
		Reporter.log("Test case ended |");
		
		
		
	}
	
	
	@AfterTest
	public void tearDown() {
		
		Reporter.log("Ending Test |");
		driver.close();
	}
}
