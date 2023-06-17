package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	static WebDriverWait wait;

	public static void setTimeOut(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertyUtil.getProperty("timeout"))));
	}

	public static void waitForElementVisible(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void waitForElementClickable(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

}
