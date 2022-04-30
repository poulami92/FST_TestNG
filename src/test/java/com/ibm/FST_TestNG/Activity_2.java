package com.ibm.FST_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_2 {
  
	private FirefoxDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void checkTitle() {
		
		String title= driver.getTitle();
		Assert.assertEquals(title, "Target Practice");
	}
	
	@Test
    public void findBlackButton() {
		
		WebElement blackBtn = driver.findElement(By.xpath("//button[text()='Black']"));
		Assert.assertEquals(blackBtn.getText(), "black");
	}
	
	@Test(enabled=false)
    public void skipTest() {
		
		System.out.println("This test will skip");
		
	}
	
	@Test
	public void skipTestException() throws SkipException{
		
		throw new SkipException("This method has not implemented yet");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
