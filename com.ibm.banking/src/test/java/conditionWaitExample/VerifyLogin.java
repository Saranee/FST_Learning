package conditionWaitExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLogin {
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void setUp() throws Exception {

		// set driver path

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		Thread.sleep(5000);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginlogout() throws Exception {
		
		
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".oxd-button")).click();
		
		//Thread.sleep(5000);
		
		
		driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
		
		//Thread.sleep(5000);
		
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		//Thread.sleep(5000);
		//driver.close();
	}
}
