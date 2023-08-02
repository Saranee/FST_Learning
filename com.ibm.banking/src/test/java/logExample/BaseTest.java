package logExample;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig_IBM;

public class BaseTest {
	
	WebDriver driver;
	ReadConfig_IBM conf;
	Logger log;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		
		log = Logger.getLogger("nopComm Application");
		PropertyConfigurator.configure(".\\testData\\log4j.properties");
		
		
		
		log.info("---------------info-------------");
		log.warn("---------------warn-------------");
		log.error("---------------error-------------");
		
		
		
		
		conf = new ReadConfig_IBM();
		
		
		
		//app1
		//driverpath
		//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		log.info("launching chrome browser");
		
		
		driver.manage().window().maximize();
		
		
		driver.get(conf.getApp());
		
		log.info("launching application: " + conf.getApp());
		
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void closingApp() throws Exception {
		
		log.info("closing an application");
		Thread.sleep(5000);
		driver.close();
		
	}

}
