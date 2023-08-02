package controlExample;

import org.openqa.selenium.Alert;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig_IBM;

public class HandleAlert2 extends BaseTest{

	WebDriver driver;
	ReadConfig_IBM conf;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		System.out.println("launching application");
		
		conf = new ReadConfig_IBM();
		
		
		
		//app1
		//driverpath
		//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		
		String browser = conf.getBrowserDetails();
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.out.println("execution on chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			
			System.out.println("execution on edge browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		
		else if(browser.equalsIgnoreCase("edge")) {
			
			System.out.println("execution on firefox browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		else {
			
			System.out.println("execution on default : chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		
		
		
		
		
//		System.out.println("execution on chrome browser");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		
		
//		System.out.println("execution on edge browser");
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		
		
		
		
		
		
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/91995/Downloads/Test.html");
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void closingApp() throws Exception {
		
		System.out.println("closing application");
		Thread.sleep(5000);
		driver.close();
		
	}

	
	
	@Test
	public void PromptAlert() throws Exception {
		
		
		WebElement button = driver.findElement(By.cssSelector("[onclick*='PromptBox()']"));
		button.click();
		
		
		Thread.sleep(6000);
		
		Alert imb_promptAlert = driver.switchTo().alert();
		
		
		
		String alertText = imb_promptAlert.getText();
		System.out.println("Alert Text: " + alertText);					//Please enter your name:
		
		
		
		
		//validation step
		Assert.assertEquals(alertText, "Please enter your name:");
				
		
		imb_promptAlert.sendKeys("Anusha");
		
		
		
		
		
		imb_promptAlert.accept();										//click on cancel button

		
		Thread.sleep(6000);
		
		
		String verify_prompt = driver.findElement(By.cssSelector("#demoPrompt")).getText();
		System.out.println("**************************** " + verify_prompt);
	}

}
