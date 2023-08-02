package testNGListnersExample;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersExample implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("execution of test case started : " + result.getName());
		System.out.println("-----------------------------------------------------------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		System.out.println("=================capture screenshot=====================");
		System.out.println("***********************" + result.getName());
		
		
//		getScreenShot(result.getName())
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
