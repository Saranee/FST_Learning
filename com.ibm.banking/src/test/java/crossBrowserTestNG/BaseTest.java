package crossBrowserTestNG;

//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig_IBM;

public class BaseTest {
	
	WebDriver driver;
	ReadConfig_IBM conf;
	
	
	
	
	@Parameters("ibm_br")
	@BeforeTest
	public void launchApp(String testNG_browserDetails) throws Exception {
		
		System.out.println("launching application");
		
		conf = new ReadConfig_IBM();
		System.out.println("*********" +conf.getApp());
		
		
		//app1
		//driverpath
		//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		
		//access value from properties file
		//String browser = conf.getBrowserDetails();
		
		
		//access value from testNG.xml
		
		System.out.println("======================" + testNG_browserDetails);
		String browser = testNG_browserDetails;
		
		
		
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
		
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
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
		driver.get(conf.getApp());
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void closingApp() throws Exception {
		
		System.out.println("closing application");
		Thread.sleep(5000);
		driver.close();
		
	}

}
