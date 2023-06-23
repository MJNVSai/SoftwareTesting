package loginCase;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase 
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
	
	
	@Test(description = "Valid Username and Valid Password", priority = 1)
	public void ValidLogin() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		String usernamelog = "Admin";
		String passwordlog = "admin123";
		
		System.out.println("Test Case 1");
		driver.findElement(By.name("username")).sendKeys(usernamelog);
		driver.findElement(By.name("password")).sendKeys(passwordlog);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		Thread.sleep(5000);
		
		String actual_message= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		String expected_message="Dashboard";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		afterTest();
	}
	
	@Test(description = "Valid Username and In_Valid Password", priority = 2)
	public void Invalid1() throws Exception
	{
		beforeTest();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		String usernamelog = "Admin";
		String passwordlog = "Admin123";
		
		System.out.println("Test Case 2");
		driver.findElement(By.name("username")).sendKeys(usernamelog);
		driver.findElement(By.name("password")).sendKeys(passwordlog);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		String actual_message= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		String expected_message="Dashboard";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		afterTest();
	}
	
	@Test(description = "In_Valid Username and Valid Password", priority = 3)
	public void Invalid2() throws Exception
	{
		beforeTest();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		String usernamelog = "Admin_sai";
		String passwordlog = "admin123";
		
		System.out.println("Test Case 3");
		driver.findElement(By.name("username")).sendKeys(usernamelog);
		driver.findElement(By.name("password")).sendKeys(passwordlog);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		String actual_message= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		String expected_message="Dashboard";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		afterTest();
	}
	
	@Test(description = "In_Valid Username and In_Valid Password", priority = 4)
	public void Invalid3() throws Exception
	{
		beforeTest();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		String usernamelog = "Admin_sai";
		String passwordlog = "admin_sai";
		
		System.out.println("Test Case 4");
		driver.findElement(By.name("username")).sendKeys(usernamelog);
		driver.findElement(By.name("password")).sendKeys(passwordlog);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		String actual_message= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		String expected_message="Dashboard";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
		afterTest();
	}
	
	@Test(description = "Empty Username and Empty Password", priority = 5)
	public void Invalid4() throws Exception
	{
		beforeTest();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		String usernamelog = "";
		String passwordlog = "";
		
		System.out.println("Test Case 5");
		driver.findElement(By.name("username")).sendKeys(usernamelog);
		driver.findElement(By.name("password")).sendKeys(passwordlog);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		String actual_message= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		String expected_message="Dashboard";
		System.out.println(actual_message);
		Assert.assertEquals(actual_message, expected_message);
	}
	
	
	@AfterTest()
	public void afterTest()
	{
		//Thread.sleep(2000);
		driver.quit();
	}
}
