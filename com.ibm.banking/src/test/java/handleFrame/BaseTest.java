package handleFrame;

//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;
import utility.ReadConfig_IBM;

public class BaseTest {

	WebDriver driver;

	@BeforeTest
	public void launchApp() throws Exception {

		System.out.println("launching application");

		System.out.println("execution on chrome browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://paytm.com/");
		Thread.sleep(5000);

	}

	@AfterTest
	public void closingApp() throws Exception {

		System.out.println("closing application");
		Thread.sleep(5000);
		//driver.close();  
		
		
		driver.quit(); //close all instance opened by driver

	}

}
