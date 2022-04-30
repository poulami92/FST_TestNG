package com.ibm.FST_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity_7 {
  
	private FirefoxDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@Test(dataProvider="Authentication")
	public void test1(String username,String password) {
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String msg= driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(msg, "Welcome Back, admin");
		
	}
	
	@DataProvider(name="Authentication")
	public Object[][] credentials() {
		
		return new Object[][] { { "admin", "password" }};	
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
