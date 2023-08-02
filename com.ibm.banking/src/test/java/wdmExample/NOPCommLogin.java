package wdmExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NOPCommLogin {
	
WebDriver driver;
	
	@Before
	public void launchApp() {
		
		System.out.println("launching application");
		
		//app1
		//driverpath
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		
		
		
		//app2
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		
		//app3
		//driver = WebDriverManager.chromedriver().create();  //wdm version: 5.0.0 
		
		
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		
	}
	
	@After
	public void closingApp() {
		
		System.out.println("closing application");
		
		//driver.close();
		//driver.quit();
		
	}

	
	@Test
	public void verifyLogin() throws Exception {
		
		Thread.sleep(4000);
		
		WebElement txtEmail = driver.findElement(By.id("Email"));
		
		txtEmail.clear();
		Thread.sleep(2000);
		txtEmail.sendKeys("admin@yourstore.com");
		
		Thread.sleep(6000);
		
		
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys("admin");
		
		driver.findElement(By.name("RememberMe")).click();
		
		driver.findElement(By.tagName("button")).click();
		
		
		
		Thread.sleep(4000);
		System.out.println("Application Title after login: " + driver.getTitle());
		System.out.println("Application URL after login : " + driver.getCurrentUrl());
		
		Thread.sleep(4000);
		
		//linkText ------ exact text
		//driver.findElement(By.linkText("Logout")).click();
		
		
		
		//partialLinkText ------ partial of text
		driver.findElement(By.partialLinkText("ogou")).click();
		
		
		
		Thread.sleep(4000);
		System.out.println("Application Title after logout: " + driver.getTitle());
		System.out.println("Application URL after logout : " + driver.getCurrentUrl());
		
		
		
		
		
		
		
		
		
		
	}
}
