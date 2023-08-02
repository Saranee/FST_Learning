package crossBrowserTestNG;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NOPCommApp extends BaseTest{

	@Test
	public void verifyLoginTest() throws Exception {
		
		
		Thread.sleep(5000);
		System.out.println("login test case");
		
		System.out.println("**************" + conf.getUserName());
		System.out.println("**************" + conf.getPassword());
		
		driver.findElement(By.cssSelector("[name='Email']")).clear();
		driver.findElement(By.cssSelector("[name='Email']")).sendKeys(conf.getUserName());
		
		
		driver.findElement(By.cssSelector("input[type=\"password\"]")).clear();
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys(conf.getPassword());
		
		
		driver.findElement(By.cssSelector("[type=\"checkbox\"]")).click();
		
		
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[href=\"/logout\"")).click();
		
	}
	
	

}
