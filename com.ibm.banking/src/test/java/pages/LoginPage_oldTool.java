package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_oldTool {

	WebDriver driver;

	public LoginPage_oldTool(WebDriver rdriver) {

		
		//this.driver = driver;
		driver = rdriver;

	}

	// identification
	By txtEmail = By.cssSelector("input#Email");
	By txtPass = By.cssSelector("input#Password");
	By chkRem = By.cssSelector("input#Password");
	By btnLogin = By.tagName("button");
	
	By btnLogout = By.partialLinkText("ogou");


	
	// Methods/Actions
	public void enterEmail(String email) {

		// driver is null
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);

	}
	
	
	
//	public void enterEmailCypress(String email) {
//
//		// driver is null
//		cy.get(txtEmail).type(email);
//
//	}

	public void enterPass(String pwd) {

		// driver is null
		driver.findElement(txtPass).clear();
		driver.findElement(txtPass).sendKeys(pwd);

	}

	public void clickRemCheckbox() {

		driver.findElement(chkRem).click();

	}

	public void clickLoginButton() {

		driver.findElement(btnLogin).click();

	}
	
	
	public void clickLogoutButton() {

		driver.findElement(btnLogout).click();

	}
	
	public void verifyApplicationTitle(String expTitle) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	
	public void login(String email, String pass) {
		
		enterEmail(email);
		enterPass(pass);
		clickLoginButton();
		
	}
	

	public boolean verifyEmailDisplayed() {

		return driver.findElement(txtEmail).isDisplayed();
	}

}
