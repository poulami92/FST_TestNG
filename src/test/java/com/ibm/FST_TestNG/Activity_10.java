package com.ibm.FST_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity_10 {
  
	private FirefoxDriver driver;
	private Actions action;

	
	@BeforeTest
	public void setUp() {
		
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.get("https://www.training-support.net/selenium/sliders");
	}
	
	@Test
	public void middleValueTest() {
		
		WebElement slider = driver.findElement(By.id("slider"));
		slider.click();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Mid value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "50");
		
	}
	
	@Test
	public void maximumValueTest() {
		
		WebElement slider = driver.findElement(By.id("slider"));
        action.dragAndDropBy(slider, 75, 0).build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "100");
		
	}
	
	@Test
	public void minimumValueTest() {
		
		WebElement slider = driver.findElement(By.id("slider"));
        action.dragAndDropBy(slider, -75, 0).build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "0");
		
	}
	
	@Test
	public void thirtyPercentValueTest() {
		
		WebElement slider = driver.findElement(By.id("slider"));
        action.dragAndDropBy(slider, -30, 0).build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "30");
		
	}
	
	@Test
	public void eightyPercentValueTest() {
		
		WebElement slider = driver.findElement(By.id("slider"));
        action.dragAndDropBy(slider, 45, 0).build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        
        Assert.assertEquals(volumeLevel, "80");
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
