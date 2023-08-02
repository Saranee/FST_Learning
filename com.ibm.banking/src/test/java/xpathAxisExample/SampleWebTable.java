package xpathAxisExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleWebTable {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(8000);
		//driver.close();
		
	}

	@Test
	public void verifyWishList() throws Exception {
		
		Thread.sleep(2000);
		WebElement chk_helen = driver.findElement(By.xpath("//td[text()='Helen Bennett']//preceding-sibling::td/input"));
		
		
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		
		JS.executeScript("arguments[0].click()", chk_helen);
		
		//chk_helen.click();
		
		Thread.sleep(6000);
		
		
		
		
	}
	
	
}
