package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKartApp {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(8000);
		driver.close();
		
	}

	@Test
	public void verifyWishList() throws Exception {
		
		
		WebElement Login = driver.findElement(By.xpath("//a[text()='Login']"));
		//WebElement signIn = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
	
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		
		Thread.sleep(4000);
		
		Actions act = new Actions(driver);
		act.moveToElement(Login).perform();
		//act.moveToElement(signIn).perform();
	}
	
	
}
