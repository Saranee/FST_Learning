package handleIRCTC;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class verifyHotelBooking extends BaseTest{

	@Test
	public void verifyLoginTest() throws Exception {
		
		
		Thread.sleep(5000);
		System.out.println("----------------verifyLoginTest----------------");
		
		String window_main = driver.getWindowHandle();
		System.out.println("parent window: " + window_main);
		
		
//		Set<String> allwindows = driver.getWindowHandles();
//		
//		int winCount = allwindows.size();
//		
//		System.out.println("how many windows opened: " + winCount);
		
		System.out.println("----------------before click on hotel ----------------");
		
		driver.findElement(By.partialLinkText("HOTELS")).click();

		System.out.println("----------------after click on hotel ----------------");
		
		Set<String> allwindows = driver.getWindowHandles();
		
		int winCount = allwindows.size();
		
		System.out.println("how many windows opened: " + winCount);
		
		
		
		String win1 = (String)allwindows.toArray()[0];
		String hotelWin = (String)allwindows.toArray()[1];
		
		
		
		System.out.println("Win1: " + win1);
		System.out.println("hotelWin: " + hotelWin);
		
		
		Thread.sleep(5000);
		
		
		
		System.out.println("Switch to hotel window");
		
		driver.switchTo().window(hotelWin);
		
		Thread.sleep(5000);
		
		
		System.out.println("Application Title: " + driver.getTitle());
		
		driver.findElement(By.partialLinkText("Login")).click();
		
		Thread.sleep(5000);
		
		
		
		System.out.println("Switch to main window");
		
		driver.switchTo().window(window_main);	
		
		
		Thread.sleep(5000);
		
		System.out.println("Application Title: " + driver.getTitle());
		driver.findElement(By.partialLinkText("CONTACT US")).click();
		Thread.sleep(5000);
		
		
		
		System.out.println("Switch to hotel window   ----- again");
		
		driver.switchTo().window(hotelWin);
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		
		Thread.sleep(5000);
		
		
		
		
	}
	
	

}
