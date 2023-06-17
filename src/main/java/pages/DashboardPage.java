package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtil;

public class DashboardPage {
	WebDriverWait wait;
	WebDriver driver;

	By menuItems = By.className("oxd-main-menu");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForMenuToLoad() {
		WaitUtil.waitForElementVisible(menuItems);
	}

}
