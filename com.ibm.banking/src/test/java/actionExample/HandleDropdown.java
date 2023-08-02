package actionExample;

import org.openqa.selenium.Alert;
//import org.junit.After;
//import org.junit.Before;
//import org.testng.annotations.Test;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class HandleDropdown {
	
	WebDriver driver;

	@AfterTest
	public void closeApp() {
		
		System.out.println("closing application");
		
		
		//close the application
		driver.close();  // -------- close the current browser instance
		//driver.quit();	-------- close all the browser instance which are opened by driver
	}
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		System.out.println("launching application");
		
		
		//app1
		//driver = WebDriverManager.chromedriver().create();
		
		
		//app2
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		
		System.out.println(Constants.alert_app);
		driver.get("https://www.amazon.in/");
		Thread.sleep(4000);
		
		
	}
	@Test
	public void handleCarList() throws Exception {
		
		WebElement signIn = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));				// match -3 
		
		
		
		
		Actions act = new Actions(driver);
		
		
		act.moveToElement(signIn).perform();
		
		
		Thread.sleep(5000);
		
	}
	
	
	

}
