package xpathAxisExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWishList {
	
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
	public void verifyWishList() throws Exception {
		
		Thread.sleep(2000);
		//WebElement link_SeeMore = driver.findElement(By.xpath("//h2[contains(text(),'Up to 60% off | Professional tools, testing & more')]//parent::div//following-sibling::div[contains(@class,'foot')]/a[text()='See more']"));
		
		
		
		WebElement link_SeeMore = driver.findElement(By.xpath("//h2[contains(text(),'your home | Up to 55')]//parent::div//following-sibling::div[contains(@class,'foot')]/a[text()='See more']"));
		
		link_SeeMore.click();
		
		Thread.sleep(2000);
		
		System.out.println("application title: " + driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Buy Industrial Scientific Supplies"));
		
		
	}
	
	
}
