package conditionWaitExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalWaitAlertExample {
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void setUp() throws Exception {

		// set driver path

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		Thread.sleep(5000);
		driver.get("http://only-testing-blog.blogspot.com/2014/01/new-testing.html?");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginlogout() throws Exception {
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		Alert myAlert = driver.switchTo().alert();
		
		System.out.println("Alert text: " + myAlert.getText());
		
		myAlert.accept();
		
		
		
	}
}
