package extentReportExample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Constants;

public class NOPCommApp  extends BaseTest{
	
	
	@Test(priority = 1)
	public void verifyLogin() {
		
		
		log.info("clear the email value");
		driver.findElement(By.cssSelector("input#Email")).clear();
		log.info("enter email: " + Constants.username);
		driver.findElement(By.cssSelector("input#Email")).sendKeys(Constants.username);
		
		log.info("clear the password value");
		driver.findElement(By.cssSelector("input#Password")).clear();
		
		log.info("enter password: " + Constants.password);
		driver.findElement(By.cssSelector("input#Password")).sendKeys(Constants.password);
		
		
		log.info("click on RememberMe checkbox");
		driver.findElement(By.cssSelector("input#RememberMe")).click();
		
		
		log.info("click on login button");
		driver.findElement(By.tagName("button")).click();
		
		
		
		log.info("application Title, after login: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		
		log.info("click on logout button");
		driver.findElement(By.partialLinkText("Logout")).click();
		
		log.info("application Title, after logout: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Your store. Login");
		
		
	}

	
	@Test(priority = 2)
	public void verifyApplicationTitle() {
		
		log.info("verifyApplicationTitle secondTest: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Your store. Login!!");
	}
}
