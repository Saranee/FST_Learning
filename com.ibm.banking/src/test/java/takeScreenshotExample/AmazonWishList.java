package takeScreenshotExample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

		WebElement SignIn = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
		WebElement createWishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish')]"));

		Actions act = new Actions(driver);
		act.moveToElement(SignIn).click(createWishList).build().perform();

		System.out.println("Application Title: " + driver.getTitle());

//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		File targetLocation = new File(".//IBM_screenshot//AmaoznSearchTest.png");
//
//		FileUtils.copyFile(screenshotFile, targetLocation);
		
		getScreenshot("IBM_SearchResult");

	}

	public void getScreenshot(String filename) throws Exception {

		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		
		
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

		File targetLocation = new File(".//IBM_screenshot//"+ filename + ".png");

		FileUtils.copyFile(screenshotFile, targetLocation);
	}

}
