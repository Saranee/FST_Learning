package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utility.Constants;

public class TestBase {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@BeforeTest
	public void launchApp() {
		
			
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(Constants.nop_app);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		//create an object on Pages
		lp = new LoginPage(driver);
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
	}
}
