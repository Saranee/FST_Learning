package exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_GiftCardTest {
	
WebDriver driver;
	
	@Before
	public void launchApp() {
		
		System.out.println("launching application");
		
		//app1
		//driverpath
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		
	}
	
	@After
	public void closingApp() {
		
		System.out.println("closing application");
		
		driver.close();
		
	}

	
	@Test
	public void verifyLogin() throws Exception {
		
		Thread.sleep(4000);
		
		//tagname: a
		//text: Today's Deals
		driver.findElement(By.linkText("Today's Deals")).click();
		
		
		
		Thread.sleep(7000);
		
		
	}
}
