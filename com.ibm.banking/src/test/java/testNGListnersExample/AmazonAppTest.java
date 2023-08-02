package testNGListnersExample;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonAppTest {
	
	
	
	
	@BeforeTest
	public void launchApp() {
		
		System.out.println("launching application");
	}
	
	@AfterTest
	public void closeApp() {
		
		System.out.println("closing application");
	}
	
	
	@Test(priority = 2)
	public void searchItem() {
		
		System.out.println("test case searchItem ---using testNG");
	}
	
	@Test(priority =5)
	public void payment() {
		
		System.out.println("test case payment ---using testNG");
		Assert.assertTrue(false);
	}
	
	//@Test(retryAnalyzer = retryExample.RetryLogic.class)
	
	@Test(priority = 4)
	public void cancelOrder() {
		
		System.out.println("test case cancelOrder ---using testNG");
		
		
		//Assert.assertTrue("Amazon - Iphone 14 pro".contains("Iphone"));
		Assert.assertTrue(false);
		
		
		
	}
	
	@Test(priority = 3)           //priority ------ 0
	public void addItem() {
		
		System.out.println("test case addItem ---using testNG");
	}
	
	@Test(priority = 1)
	public void login() {
		
		System.out.println("test case login ---using testNG");
	}
	
	
	@Test(priority = 6)
	public void logout() {
		
		System.out.println("test case logout ---using testNG");
	}

}
