package RegisterCase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.lang.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTestCase 
{
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver = new ChromeDriver(options);
	}
	
	@Test(description = "Giving All Valid Values To the Form", priority = 1)
	public void ValidRegister() throws Exception
	{
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("gender-male")).click();
//		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.name("FirstName")).sendKeys("Sai");
		driver.findElement(By.name("LastName")).sendKeys("MJNV");
		driver.findElement(By.name("Email")).sendKeys("mjnvsai45@gmail.com");
		
		driver.findElement(By.name("Password")).sendKeys("sai12345");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("sai12345");
		
		System.out.print("Test Case - 1");
		
		driver.findElement(By.name("register-button")).click();
		
		driver.findElement(By.xpath("(//input)[5]")).click();
		String actual_message= driver.findElement(By.className("topic-html-content-header")).getText();
		String expected_message="Welcome to our store";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		
		System.out.print("Test Case 1 passed");
		afterTest();
	}
	
	@Test(description = "Giving All In Valid Values To the Form", priority = 2)
	public void InValid() throws Exception
	{
		beforeTest();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("gender-male")).click();
//		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.name("FirstName")).sendKeys("fhjsdvjhfb");
		driver.findElement(By.name("LastName")).sendKeys("fsdfj sjdg");
		driver.findElement(By.name("Email")).sendKeys("mjnvsai45@gmail.com");
		
		driver.findElement(By.name("Password")).sendKeys("ertyui");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("ertyui");
		
		System.out.print("Test Case - 2");
		
		driver.findElement(By.name("register-button")).click();
		
		driver.findElement(By.xpath("(//input)[5]")).click();
		String actual_message= driver.findElement(By.className("topic-html-content-header")).getText();
		String expected_message="Welcome to our store";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		
		System.out.print("Test Case 2 passed");
		afterTest();
	}
	
	@Test(description = "Special Characters are allowing in the First and Last name", priority = 3)
	public void InValid2() throws Exception
	{
		beforeTest();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("gender-male")).click();
//		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.name("FirstName")).sendKeys("fhjsdv@#$%_-hu");
		driver.findElement(By.name("LastName")).sendKeys("fsdfj ^&%$!@ sai _-");
		driver.findElement(By.name("Email")).sendKeys("jdfjsbfb@jbsajyuio.euir");
		
		driver.findElement(By.name("Password")).sendKeys("ertyui");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("ertyui");
		
		System.out.print("Test Case - 3");
		
		driver.findElement(By.name("register-button")).click();
		
		driver.findElement(By.xpath("(//input)[5]")).click();
		String actual_message= driver.findElement(By.className("topic-html-content-header")).getText();
		String expected_message="Welcome to our store";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		
		System.out.print("Test Case 3 passed");
		afterTest();
	}
	
	@Test(description = "if Email field is accepting only numbers as Email (without @ and .com or .co.in etc.,)", priority = 4)
	public void Invalid3() throws Exception
	{
		beforeTest();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("gender-male")).click();
//		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.name("FirstName")).sendKeys("fhasdbv@#$%_-hu");
		driver.findElement(By.name("LastName")).sendKeys("fsdaabfj ^poi&%$!@ sai _-");
		driver.findElement(By.name("Email")).sendKeys("12345987");
		
		driver.findElement(By.name("Password")).sendKeys("ertyui");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("ertyui");
		
		System.out.print("Test Case - 4");
		
		driver.findElement(By.name("register-button")).click();
		
		driver.findElement(By.xpath("(//input)[5]")).click();
		String actual_message= driver.findElement(By.className("topic-html-content-header")).getText();
		String expected_message="Welcome to our store";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		
		System.out.print("Test Case 4 passed");
		afterTest();
	}
	
	@Test(description = "if Email field is accepting only Special Characters as Email (without @and .comor .co.in etc.,)", priority = 5)
	public void Invalid4() throws Exception
	{
		beforeTest();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("gender-male")).click();
//		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.name("FirstName")).sendKeys("ffhasdbv@#$%_-hu");
		driver.findElement(By.name("LastName")).sendKeys("fsyaabfj ^&%$!@ sai _-");
		driver.findElement(By.name("Email")).sendKeys("$^$%$$^$&*#_-+=");
		
		driver.findElement(By.name("Password")).sendKeys("ertyui");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("ertyui");
		
		System.out.print("Test Case - 5");
		
		driver.findElement(By.name("register-button")).click();
		
		driver.findElement(By.xpath("(//input)[5]")).click();
		String actual_message= driver.findElement(By.className("topic-html-content-header")).getText();
		String expected_message="Welcome to our store";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		
		System.out.print("Test Case 5 passed");
	}
	
	@AfterTest()
	public void afterTest() throws Exception
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
