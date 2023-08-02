package unitExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriorityExample {
	
	
	//Priority   
	
	//by default priority : 0
	//highest negative number having highest priority 
	//if priority is same ----- as per naming conv ......... ascii value
	
	
	
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
	
	@Test(priority = 2)
	public void payment() {
		
		System.out.println("test case payment ---using testNG");
	}
	
	@Test(priority = 3, enabled = false)
	public void cancelOrder() {
		
		System.out.println("test case cancelOrder ---using testNG");
	}
	
	@Test           //priority ------ 0
	public void addItem() {
		
		System.out.println("test case addItem ---using testNG");
	}
	
	@Test(priority = -1, description = "login with valid user crednetials")
	public void login() {
		
		System.out.println("test case login ---using testNG");
	}
	
	
	@Test(priority = 11)
	public void logout() {
		
		System.out.println("test case logout ---using testNG");
	}

}
