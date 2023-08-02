package controlExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HandleListbox extends BaseTest{

	@Test
	public void verifyCountryList() throws Exception {
		
		
		Thread.sleep(5000);
		
		
		WebElement country_list = driver.findElement(By.cssSelector("[name='FromLB']"));
		
		
		
		Select list = new Select(country_list);
		
		
		
		System.out.println("Country: is dropdown accept multiple selection or not: " + list.isMultiple());
		
		list.selectByIndex(0);
		list.selectByIndex(4);
		
		Thread.sleep(1000);
		
		list.selectByValue("Japan");
		Thread.sleep(1000);
		list.selectByVisibleText("Germany");
		
		
		
		
		Thread.sleep(5000);
		
		
		list.deselectByIndex(0);
		list.deselectByValue("Germany");
		list.deselectByVisibleText("Japan");
		
		Thread.sleep(5000);
	}
	
	
	@Test
	public void verifyCarList() throws Exception {
		
		
		Thread.sleep(5000);
		
		
		WebElement carList = driver.findElement(By.cssSelector("select"));
		
		
		
		Select list = new Select(carList);
		
		System.out.println("Car: is dropdown accept multiple selection or not: " + list.isMultiple());
		
		list.selectByIndex(1);						//Saab
		Thread.sleep(2000);
		list.selectByIndex(4);						//Toyata
		
		Thread.sleep(2000);
		
		list.selectByValue("Singapore");			//opel
		Thread.sleep(2000);
		list.selectByVisibleText("Audi");			//Audi
		
		Thread.sleep(5000);
		
		
		
	}
	
	

}
