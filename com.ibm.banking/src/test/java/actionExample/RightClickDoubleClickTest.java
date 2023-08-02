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

public class RightClickDoubleClickTest {
	
	WebDriver driver;

	@AfterTest
	public void closeApp() throws InterruptedException {
		
		System.out.println("closing application");
		
		Thread.sleep(7000);
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
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		Thread.sleep(4000);
		
		
	}
	
	
	@Test
	public void rightClickTest() throws Exception {
		
		WebElement btnRightClick = driver.findElement(By.xpath("//span[contains(text(),'right')]"));				
		//WebElement btnDoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Dou')]"));	
		
		
		
		//action class
		
		
		Actions act = new Actions(driver);
		act.contextClick(btnRightClick).perform();
		
		
		
	}
	
	
	@Test
	public void doubleClickTest() throws Exception {
		
		//WebElement btnRightClick = driver.findElement(By.xpath("//span[contains(text(),'right')]"));				
		WebElement btnDoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Dou')]"));	
		
		
		
		//action class
		
		
		Actions act = new Actions(driver);
		act.doubleClick(btnDoubleClick).perform();
		
		
		
		
		String alertTExt = driver.switchTo().alert().getText();
		System.out.println("alertTExt " + alertTExt);
		
		
		Thread.sleep(4000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(4000);
		
		
		
	}

}
