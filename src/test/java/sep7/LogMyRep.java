package sep7;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class LogMyRep implements ITestListener {

	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName());
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName());
		
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log(result.getName());
		
	}

	public void onStart(ITestContext context) {
		Reporter.log(context.getName());
 
		
	}

	public void onFinish(ITestContext context) {
		Reporter.log(context.getName());
		
	}

}
