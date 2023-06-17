package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashboardPage;
import pages.LoginPage;
import utilities.ExcelUtil;
import utilities.ScreenshotUtil;
import utilities.WebDriverUtil;

public class LoginTest {

	WebDriver driver;
	SoftAssert softAssert;
	LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		driver = WebDriverUtil.getDriver();
		softAssert = new SoftAssert();
		loginPage = new LoginPage(driver);
	}

	@Test(dataProvider = "getLoginData")
	public void testInvalidLogin(String username, String password) {
		loginPage = new LoginPage(driver);
		loginPage.performLogin(username, password);
		softAssert.assertEquals(loginPage.getValidationMessage(), "Invalid credentials",
				"Invalid login validation message not proper");
		softAssert.assertAll();
	}

	@DataProvider
	public Object[][] getLoginData(Method method) {
		String name = method.getName();
		Object[][] obj = null;
		if (name.equals("testInvalidLogin")) {
			obj = ExcelUtil.getTestDataFromExcel("LoginTestData.xlsx", "InvalidData");
		} else if (name.equals("testValidLogin")) {
			obj = ExcelUtil.getTestDataFromExcel("LoginTestData.xlsx", "ValidData");
		}
		return obj;
	}

	@Test(dataProvider = "getLoginData")
	public void testValidLogin(String username, String password) {
		loginPage = new LoginPage(driver);
		loginPage.performLogin(username, password);
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.waitForMenuToLoad();
		softAssert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
				"URL after successful login not proper");
		softAssert.assertAll();
	}

	@AfterMethod
	public void quitDriver(ITestResult result) {
		if (!result.isSuccess()) {
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
		WebDriverUtil.quitDriver();
	}

}
