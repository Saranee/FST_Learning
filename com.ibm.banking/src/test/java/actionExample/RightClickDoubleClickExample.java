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

public class RightClickDoubleClickExample {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(8000);
		driver.close();
		
	}

	@Test
	public void verifyWishList() {
		
		
		WebElement SignIn = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
		WebElement createWishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish')]"));
	
		Actions act = new Actions(driver);
		
		//app1
//		act.moveToElement(SignIn).perform();;
//		act.moveToElement(createWishList).perform();;
//		act.click().perform();;
		
		
		
		
		

		//app2
		//act.moveToElement(SignIn).moveToElement(createWishList).click().perform();
		
		
//		//app3
//		act.moveToElement(SignIn).click(createWishList).perform();
		
		
		//app4
		act.moveToElement(SignIn).click(createWishList).build().perform();
		
		System.out.println("Application Title: " + driver.getTitle());
		
	}
	
	
}
