package logExampleTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NOPCommApp extends BaseTest{

	@Test
	public void verifyLoginTest() throws Exception {
		
		
		Thread.sleep(5000);
		log.info("login test case, enter user credenatils");
		
		
		
		
		driver.findElement(By.cssSelector("[name='Email']")).clear();
		
		log.info("clear the email");
		driver.findElement(By.cssSelector("[name='Email']")).sendKeys(conf.getUserName());
		log.info("enter email: " + conf.getUserName());
		
		
		driver.findElement(By.cssSelector("input[type=\"password\"]")).clear();
		log.info("clear the password");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys(conf.getPassword());
		log.info("enter password" + conf.getPassword());
		
		
		log.info("click on remmember me checkbox");
		
		driver.findElement(By.cssSelector("[type=\"checkbox\"]")).click();
		
		log.info("click on login button");
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		Thread.sleep(5000);
		
		
		log.info("application title after login: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		
		log.info("click on logout button");
		driver.findElement(By.cssSelector("[href=\"/logout\"")).click();
		
		Thread.sleep(5000);
		log.info("application title after logout: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Your store. Login");
		
	}
	
	

}
