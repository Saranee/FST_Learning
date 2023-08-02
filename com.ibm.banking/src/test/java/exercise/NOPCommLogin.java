package exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NOPCommLogin {
	
WebDriver driver;
	
	@Before
	public void launchApp() {
		
		System.out.println("launching application");
		
		//app1
		//driverpath
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		
	}
	
	@After
	public void closingApp() throws Exception {
		
		System.out.println("closing application");
		Thread.sleep(4000);
		driver.close();
		
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
		
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		Thread.sleep(4000);
		System.out.println("Application Title after logout: " + driver.getTitle());
		System.out.println("Application URL after logout : " + driver.getCurrentUrl());
		
		
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//*[@type='checkbox']")).click();
		
		
		//driver.findElement(By.xpath("//input[@data-val-required=\"The Remember me? field is required.\"]")).click();
		driver.findElement(By.xpath("//input[@data-val-required='The Remember me? field is required.']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
	}
}
