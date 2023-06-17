package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utilities.ElementUtil;
import utilities.ReportUtil;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");
	By lblValidationMsg = By.xpath("//p[contains(@class,'alert-content-text')]");

	public void performLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

	public void enterUsername(String username) {
		ElementUtil.enterText(driver, txtUsername, username);
		ReportUtil.extentLogger(Status.INFO, "Entered username: " + username);

	}

	public void enterPassword(String password) {
		ElementUtil.enterText(driver, txtPassword, password);
		ReportUtil.extentLogger(Status.INFO, "Entered password: " + password);
	}

	public void clickLogin() {
		ElementUtil.clickElement(driver, btnLogin);
		ReportUtil.extentLogger(Status.INFO, "Clicked on Login button");
	}

	public String getValidationMessage() {
		return ElementUtil.getElementText(driver, lblValidationMsg);
	}

}
