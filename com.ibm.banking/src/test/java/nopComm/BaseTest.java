package nopComm;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig_IBM;

public class BaseTest {
	
	WebDriver driver;
	ReadConfig_IBM conf;
	
	@Before
	public void launchApp() throws Exception {
		
		System.out.println("launching application");
		
		conf = new ReadConfig_IBM();
		System.out.println("*********" +conf.getApp());
		
		
		//app1
		//driverpath
		//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		
		
		
		driver.manage().window().maximize();
		driver.get(conf.getApp());
		Thread.sleep(5000);
		
	}
	
	@After
	public void closingApp() throws Exception {
		
		System.out.println("closing application");
		Thread.sleep(5000);
		driver.close();
		
	}

}
