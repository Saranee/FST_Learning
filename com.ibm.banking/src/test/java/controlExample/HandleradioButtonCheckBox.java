package controlExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleradioButtonCheckBox extends BaseTest{

	@Test
	public void verifyCheckbox() throws Exception {
		
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.cssSelector("[name=vehicle]")).click();    //multiple element --- 3, by default --- perform action on first element
		
		
		Thread.sleep(5000);
		
	}
	
	
	
	@Test
	public void verifyRadioButton() throws Exception {
		
		
		
		driver.findElement(By.cssSelector("input[value=female]")).click();    //multiple element --- 3, by default --- perform action on first element
		
		
		Thread.sleep(5000);
		
	}
	
	

}
