package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

	static WebDriver driver;

	public static WebDriver getDriver() {
		String browserName = PropertyUtil.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		WaitUtil.setTimeOut(driver);
		driver.manage().window().maximize();
		driver.get(PropertyUtil.getProperty("url"));
		return driver;
	}

	public static void quitDriver() {
		driver.quit();
	}

}
