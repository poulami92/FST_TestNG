package com.ibm.FST_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_5 {
  
	private FirefoxDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void checkTitle() {
		
		String title = driver.getTitle();
		System.out.println("Titlt of the Page :"+title);
		
	}
	
	@Test(groups = {"HeaderTests"})
	public void headerTest1() {
		
		String thirdHeader = driver.findElement(By.xpath("//h3[text()='Third header']")).getText();
		System.out.println("3rd Header of the Page :"+thirdHeader);
		Assert.assertEquals(thirdHeader, "Third header");
		
	}
	
	@Test(groups = {"HeaderTests"})
	public void headerTest2() {
	
		WebElement fifthHeader = driver.findElement(By.xpath("//h5[text()='Fifth header']"));
		String color=fifthHeader.getCssValue("color");
		Assert.assertEquals(color, "rgb(33, 186, 69)");
		
	}
	
	@Test(groups = {"ButtonTests"})
	public void buttonTest1() {
	
		WebElement oliveBtn = driver.findElement(By.xpath("//button[contains(@class,'olive')]"));
		Assert.assertEquals(oliveBtn.getText(), "Olive");
		
	}
	
	@Test(groups = {"ButtonTests"})
	public void buttonTest2() {
	
		WebElement brownBtn = driver.findElement(By.xpath("//button[contains(@class,'brown')]"));
		Assert.assertEquals(brownBtn.getText(), "Brown");
		
	}
	
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
}
