package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	public static WebElement findElement(WebDriver driver, By by) {
		WaitUtil.waitForElementVisible(by);
		return driver.findElement(by);
	}

	public static void clickElement(WebDriver driver, By by) {
		findElement(driver, by).click();
	}

	public static void enterText(WebDriver driver, By by, String text) {
		findElement(driver, by).clear();
		findElement(driver, by).sendKeys(text);
	}

	public static String getElementText(WebDriver driver, By by) {
		return findElement(driver, by).getText();
	}

}
