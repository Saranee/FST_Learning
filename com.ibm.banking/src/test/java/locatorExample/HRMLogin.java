package locatorExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HRMLogin extends BaseTest{
	
	
//	/unit testing framework ------- JUNIT ------> TESTNG
	//Before  ----- pre -condition
	//After   ---- post-condition
	//Test    ---- TestCase
	
	
//	id
//	name
//	classname
//	tagname
//
//
//	linkText
//	partialLinkText
//
//	xpath
//	css Selector
//	
	
	
	
	@Test
	public void verifyLoginTest() throws Exception {
		
		
		Thread.sleep(5000);
		System.out.println("login test case");
		
		//name
		WebElement txt_username = driver.findElement(By.name("username"));
		txt_username.sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		
		//login button ---- tagname
		
		driver.findElement(By.tagName("button")).click();
		
		Thread.sleep(5000);
		
		System.out.println("Application URL: after login:  " + driver.getCurrentUrl());
		System.out.println("Application Title: " + driver.getTitle());
		
		
		
		
		//classname
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		Thread.sleep(3000);
		
		
		
		//linkText
		//driver.findElement(By.linkText("Logout")).click();
		
		
		
		
		//partialLinkText
		driver.findElement(By.partialLinkText("ogo")).click();
		
		Thread.sleep(3000);
		
	}
	
	

}
