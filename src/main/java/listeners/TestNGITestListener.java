package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utilities.ReportUtil;

public class TestNGITestListener implements ITestListener {

	public void onStart(ITestContext context) {
		ReportUtil.setupExtentReporter();
	}

	public void onFinish(ITestContext context) {
		ReportUtil.flushExtentReport();
	}

	public void onTestStart(ITestResult result) {
		ReportUtil.createExtentTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		ReportUtil.extentLogger(Status.PASS, result.getName() + " is passed");
	}

	public void onTestFailure(ITestResult result) {
		ReportUtil.extentLogger(Status.FAIL, result.getThrowable(), result.getName());
	}
}
