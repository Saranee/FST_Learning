package javascriptExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SmapleAppDisabled  extends BaseTest{
	
	
	
	@Test
	public void verifyInputbox() throws Exception {
		
		
		WebElement fName = driver.findElement(By.name("fname"));
		fName.sendKeys("enter first name");
		
		Thread.sleep(4000);
		
		WebElement lName = driver.findElement(By.name("lname"));
		//lName.sendKeys("enter last name");
		
		
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].value='enter your last name'", lName);
		
		
		
	}

}
