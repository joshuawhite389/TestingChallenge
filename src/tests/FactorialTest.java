package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class FactorialTest {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		
	}
	
	
	//reloads for new test
	
	@Before
	public void clear() {
		driver.get("http://qainterview.pythonanywhere.com/");
		
	}
	

	//scenario 1 user enters positive integer
	
	@Test
	public void posInt() {
		driver.findElement(By.id("number")).sendKeys("4");
		driver.findElement(By.id("getFactorial")).click();
		String text = driver.findElement(By.id("resultDiv")).getText();
		String expectedText = "The factorial of 4 is: 24";
		Assert.assertEquals(expectedText, text);
		
	}
	
	//scenario 2 user enters 0
	
	@Test
	public void zero() {
		driver.findElement(By.id("number")).sendKeys("0");
		driver.findElement(By.id("getFactorial")).click();
		String text = driver.findElement(By.id("resultDiv")).getText();
		String expectedText = "The factorial of 0 is: 1";
		Assert.assertEquals(expectedText, text);
				
		
	}
	
	//enter string helper method
	
	public void enterString() {
		driver.findElement(By.id("number")).sendKeys("hello world");
		driver.findElement(By.id("getFactorial")).click();
	}
	
	
	//scenario 3 user enters string
	
	@Test
	public void enterStringText() {
		enterString();
		String expectedText = "Please enter an integer";
		String text = driver.findElement(By.id("resultDiv")).getText();
		Assert.assertEquals(expectedText, text);
		
		
	}
	
	@Test
	public void enterStringBorderColor() {
		enterString();
		String borderColor = driver.findElement(By.id("number")).getCssValue("border-top-color");
		String red = "rgb(255, 0, 0)";
		Assert.assertEquals(red, borderColor);
		
	}
	
	@Test
	public void enterStringTextColor() {
		enterString();
		String textColor = driver.findElement(By.id("resultDiv")).getCssValue("color");
		String red = "rgb(255, 0, 0)";
		Assert.assertEquals(red, textColor);
		
	}
	
	
	//scenario 4 user clicks terms and conditions link
	
	@Test
	public void termsAndConditionsText() {
		driver.findElement(By.xpath("/html/body/div[2]/div/p[1]/a[1]")).click();
		String expectedTermsText = "This is the terms and conditions document. We are not yet ready with it. Stay tuned!";
		String termsText = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(expectedTermsText, termsText);
		
		
	}
	
	@Test
	public void termsAndConditionsUrl() {
				
		String expectedTermsUrl = "http://qainterview.pythonanywhere.com/terms";
		String termsUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedTermsUrl, termsUrl);
		
	}
	
	
	
	//close the browser
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
