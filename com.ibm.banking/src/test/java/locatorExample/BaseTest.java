package locatorExample;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	WebDriver driver;
	
	@Before
	public void launchApp() {
		
		System.out.println("launching application");
		
		//app1
		//driverpath
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
	}
	
	@After
	public void closingApp() {
		
		System.out.println("closing application");
		
		driver.close();
		
	}

}
