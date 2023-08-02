package controlExample;

import org.openqa.selenium.Alert;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest{

	//@Test
	public void SimpleAlert() throws Exception {
		
		
		WebElement button = driver.findElement(By.cssSelector("input[value*='Me Alert']"));
		button.click();
		
		
		Thread.sleep(4000);
		
		//handle an alert
		
//		accept()	------- perform an action "click" on OK button
//		dismiss()
//		getText()
//		sendkeys()
		
		
		Alert ibm_SimpleAlert = driver.switchTo().alert();
		
		
		
		String alertText = ibm_SimpleAlert.getText();
		System.out.println("Alert Text: " + alertText);
		
		
		ibm_SimpleAlert.dismiss();


		
		Thread.sleep(4000);
	}
	
	
	
	
	//@Test
	public void ConfirmAlert() throws Exception {
		
		
		WebElement button = driver.findElement(By.cssSelector("button[onclick='myFunction()']"));
		button.click();
		
		
		Thread.sleep(4000);
		
		//handle an alert
		
//		accept()	------- perform an action "click" on OK button
//		dismiss()
//		getText()
//		sendkeys()
		
		
		Alert imb_confirmAlert = driver.switchTo().alert();
		
		
		
		String alertText = imb_confirmAlert.getText();
		System.out.println("Alert Text: " + alertText);					//Press 'OK' or 'Cancel' button!
		
		
		
		
		//validation step
		Assert.assertEquals(alertText, "Press 'OK' or 'Cancel' button!");
				
		
		
		imb_confirmAlert.dismiss();										//click on cancel button

		
		String ok_cancel_text = driver.findElement(By.cssSelector("#demo")).getText();
		System.out.println("ok_cancel_text: " + ok_cancel_text);
		
		Assert.assertEquals(ok_cancel_text, "You pressed Cancel!");
		
		Thread.sleep(4000);
	}
	
	
	@Test
	public void PromptAlert() throws Exception {
		
		
		WebElement button = driver.findElement(By.cssSelector("[onclick*=\"tionf()\"]"));
		button.click();
		
		
		Thread.sleep(6000);
		
		//handle an alert
		
//		accept()	------- perform an action "click" on OK button
//		dismiss()
//		getText()
//		sendkeys()
		
		
		Alert imb_promptAlert = driver.switchTo().alert();
		
		
		
		String alertText = imb_promptAlert.getText();
		System.out.println("Alert Text: " + alertText);					//Press 'OK' or 'Cancel' button!
		
		
		
		
		//validation step
		Assert.assertEquals(alertText, "Your Name Please");
				
		
		imb_promptAlert.sendKeys("Imtiaz");
		
		
		
		
		
		imb_promptAlert.accept();										//click on cancel button

		
		Thread.sleep(4000);
	}

}
