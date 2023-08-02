package exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;
import utility.ReadConfig_IBM;

public class NOPCommLogin_config {

	WebDriver driver;
	ReadConfig_IBM IBMpropertyFile;

	@Before
	public void launchApp() throws Exception {

		System.out.println("launching application");

		// app1
		// driverpath
		//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		
		
		
		//app2
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		IBMpropertyFile = new ReadConfig_IBM();

		System.out.println("application url form config file: " + IBMpropertyFile.getApp());

		driver.get(IBMpropertyFile.getApp());

	}

	@After
	public void closingApp() {

		System.out.println("closing application");

		driver.close();

	}

	@Test
	public void verifyLogin() throws Exception {
		
		Thread.sleep(4000);
		
		WebElement txtEmail = driver.findElement(By.id("Email"));
		
		txtEmail.clear();
		Thread.sleep(2000);
		
		
		System.out.println(IBMpropertyFile.getUserName());
		txtEmail.sendKeys(IBMpropertyFile.getUserName());
		
		Thread.sleep(6000);
		
		
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys(IBMpropertyFile.getPassword());
		
		driver.findElement(By.name("RememberMe")).click();
		
		driver.findElement(By.tagName("button")).click();
		
		
		
		Thread.sleep(4000);
		System.out.println("Application Title after login: " + driver.getTitle());
		System.out.println("Application URL after login : " + driver.getCurrentUrl());
		
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		Thread.sleep(4000);
		System.out.println("Application Title after logout: " + driver.getTitle());
		System.out.println("Application URL after logout : " + driver.getCurrentUrl());
		
	}
}
