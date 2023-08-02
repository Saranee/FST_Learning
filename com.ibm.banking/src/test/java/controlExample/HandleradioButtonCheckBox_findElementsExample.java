package controlExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleradioButtonCheckBox_findElementsExample extends BaseTest{

	@Test
	public void verifyCheckbox() throws Exception {
		
		
		Thread.sleep(5000);
		System.out.println("login test case");
		
		
		
		List<WebElement> allvehicle = driver.findElements(By.cssSelector("[name=vehicle]"));    //multiple element --- 3, by default --- perform action on first element
		
		
		System.out.println("how many vechicle are present: " + allvehicle.size());
		
		
//		allvehicle.get(0).click();
//		allvehicle.get(1).click();
		
		
		for (int i = 0; i < allvehicle.size(); i++) {
			
			
			allvehicle.get(i).click();
			
		}
		
		
		
		
		
		Thread.sleep(7000);
		
	}
	
	

}
