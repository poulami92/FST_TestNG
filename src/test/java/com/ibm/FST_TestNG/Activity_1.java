package com.ibm.FST_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_1 {
  
	private FirefoxDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	
	@Test
	public void checkTitle() {
		
		String title= driver.getTitle();
		System.out.println("Title of the page is :"+title);
		Assert.assertEquals(title, "Training Support");
		
		driver.findElement(By.id("about-link")).click();
		title= driver.getTitle();
		System.out.println("Title of the new page is :"+title);
		Assert.assertEquals(title, "About Training Support");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
