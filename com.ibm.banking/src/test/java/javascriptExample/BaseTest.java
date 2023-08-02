package javascriptExample;

//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig_IBM;

public class BaseTest {
	
	WebDriver driver;
	ReadConfig_IBM conf;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		System.out.println("launching application");
		
		conf = new ReadConfig_IBM();
		
		
		
		//app1
		//driverpath
		//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		
		String browser = conf.getBrowserDetails();
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.out.println("execution on chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			
			System.out.println("execution on edge browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		
		else if(browser.equalsIgnoreCase("edge")) {
			
			System.out.println("execution on firefox browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		else {
			
			System.out.println("execution on default : chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		
		
		
		
		
//		System.out.println("execution on chrome browser");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		
		
//		System.out.println("execution on edge browser");
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		
		
		
		
		
		
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void closingApp() throws Exception {
		
		System.out.println("closing application");
		Thread.sleep(5000);
		driver.close();
		
	}

}
