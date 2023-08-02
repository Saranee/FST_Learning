package conditionWaitExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class ConditionalWaitAlert {
	
	WebDriver driver;

	@AfterTest
	public void closeApp() throws InterruptedException {
		
		System.out.println("closing application");
		
		Thread.sleep(7000);
		//close the application
		//driver.close();  // -------- close the current browser instance
		driver.quit();	//-------- close all the browser instance which are opened by driver
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
		
		//Thread.sleep(4000);
		
		
		System.out.println(Constants.hrmApp);
		driver.get("http://only-testing-blog.blogspot.com/2014/01/new-testing.html?");
		//Thread.sleep(4000);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(10000);
		
	}
	@Test
	public void verifyLoginFeature() throws Exception {
		
		//handle sync issue
		
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		
		
		Alert myAlert = driver.switchTo().alert();
		
		System.out.println("Alert Text: " + myAlert.getText());
		
		//Thread.sleep(2000);
		myAlert.dismiss();
		
		
		
	}
	
	
	

}
