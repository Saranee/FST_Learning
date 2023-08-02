package extentReportExample;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class BaseTest {
	public static WebDriver driver;
	Logger log;

	@BeforeTest
	public void launchApp() throws Exception {

		// log configuration

		log = Logger.getLogger("nopComm App");
		PropertyConfigurator.configure(".\\testData\\log4j.properties");

		log.info("--------------info----------------");
		log.warn("--------------warn----------------");
		log.error("--------------error----------------");

		log.info("launching chrome browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		log.info("launching application: " + Constants.nop_app);
		driver.get(Constants.nop_app);
		Thread.sleep(5000);
	}

	@AfterTest
	public void closeApp() throws Exception {
		log.info("closing an application: ");

		Thread.sleep(7000);
		driver.close();

	}

	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/IBM_Module_" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);

		return destination;
	}
}
