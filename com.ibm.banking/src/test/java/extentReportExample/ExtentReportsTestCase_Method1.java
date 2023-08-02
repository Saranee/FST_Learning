package extentReportExample;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsTestCase_Method1 {
	
	
	
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeTest
	public void startReport() {
	
		String dateName_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());    //unique -----ext
		
		htmlReporter = new ExtentHtmlReporter("./test-output/IBM_extentReport/IBM_ExtentReport_final"+dateName_number+".html");
		
		
		
		// Create an object of Extent Reports
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		
		
		//System.out.println(System.getenv("ANDROID_HOME"));
		
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "Rajesh Singh");
		extent.setSystemInfo("IBM batch", "Module 1");
		
		
		htmlReporter.config().setDocumentTitle("IBM - Functional Automation/API Report module1");
		// Name of the report
		htmlReporter.config().setReportName("IBM Regression Report");
		// Dark Theme
		//htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/IBM_Module_" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		
		FileUtils.copyFile(source, finalDestination);
		
		
		return destination;
	}

	
	
	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	
	@Test
	public void verifyTitle() {
		logger = extent.createTest("To verify Google Title......addedtest");
		Assert.assertEquals(driver.getTitle(), "Google"); 				//pass
	}
	
	
	@Test
	public void verifyApplicationSearchTest() {
		logger = extent.createTest("To verify verifyApplicationSearchTest");
		Assert.assertEquals(driver.getTitle(), "Google"); 				//pass
	}


	@Test
	public void verifyLogo() {
		logger = extent.createTest("To verify Google Logo");

		
		
		//boolean img = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();			//true
		
		boolean img = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		
		
		System.out.println("***************Image present: " + img);
		
		logger.createNode("Image is Present");
		Assert.assertTrue(img); 						//true-----pass
		
		
		
		logger.createNode("Image is not Present");
		Assert.assertFalse(img); 						//failed

	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			
			
			// MarkupHelper is used to display the output in different colors
			
			
			
			//									verifyLogo - Test Case Failed
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			
			
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.CYAN));
			
			
			
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			
			
															//verifyLogo
			String screenshotPath = getScreenShot(driver, result.getName());
			
		
			// To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
			
			
			
			
		} 
		
		
		else if (result.getStatus() == ITestResult.SKIP) {
			
			
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			
			
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			
			
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			
			logger.log(Status.PASS, "result.getName() -  test case passed message !!");
			logger.log(Status.INFO, "result.getName() -  test case info details message !!");
			
		}
		driver.quit();
	}

	
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
		
		
		
	}
}