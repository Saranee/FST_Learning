package conditionWaitExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class HRMLoginApp {
	
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
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//Thread.sleep(4000);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(10000);
		
	}
	@Test
	public void verifyLoginFeature() throws Exception {
		
		//handle sync issue
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		
		driver.findElement(By.tagName("button")).click();
		
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		
		driver.findElement(By.partialLinkText("Logout")).click();
		
		
		
	}
	
	
	

}
