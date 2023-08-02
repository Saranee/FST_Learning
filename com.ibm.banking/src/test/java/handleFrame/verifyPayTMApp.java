package handleFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyPayTMApp extends BaseTest{

	@Test
	public void verifyLoginTest() throws Exception {
		
		
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Sign')]")).click();
		
		Thread.sleep(5000);
		
		
		
		//inside a frame
		//handle an iframe
		
		//index  ---- sstart from 0
		//name or id
		//webelement
		
		//driver.switchTo().frame(0);
		
		//driver.switchTo().frame("name or id");
		WebElement payTM_Frame = driver.findElement(By.cssSelector("iframe[src*='paytm-web']"));
		
		driver.switchTo().frame(payTM_Frame);
		
		
		
		String frameHeading = driver.findElement(By.cssSelector(".heading")).getText();
		System.out.println("frame heading: " + frameHeading);
		
		Assert.assertEquals(frameHeading, "To Login into your Paytm Web account");
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();
		
		
		
		
		
		
	}
	
	

}
