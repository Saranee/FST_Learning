package ddtExample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NOpCommLogin extends BaseTest{
	
	
	@Test(dataProvider = "regressionTestData")
	public void verifyLoginWithInvalidcred(String email, String pwd) throws Exception {
		
		Thread.sleep(3000);
		System.out.println("user details are: " + email + " : " + pwd);
		
		//testing application with invalid credentials 
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#Password")).sendKeys(pwd);
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#RememberMe")).click();
		driver.findElement(By.tagName("button")).click();
		
		
		Thread.sleep(3000);
		//validationStep
		Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful"));
		
		
	}
	
	
	
	
	@DataProvider
	public Object[][] smokeTestData() {
		
		
		Object [][] data = { {"aasha@gmail.com", "welcome"}, {"ajay@google.com", "demo"},  {"imtiaz@yahoo.com", "demo123"}};
		
		return data;
		
	}

	
	@DataProvider
	public Object[][] regressionTestData() {
		
		
		Object [][] data = { {"aashaRegression@gmail.com", "welcome"}, {"ajayRegression@google.com", "demo"},  {"imtiazRegression@yahoo.com", "demo123"},  {"deepakRegression@yahoo.com", "demo123"}};
		
		return data;
		
	}
	
	
}
