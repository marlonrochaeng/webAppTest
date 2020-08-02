package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	private static int IMPLICITY_WAIT_DEFAULT_TIME = 30;

	
	public static WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();

		return driver;
	}
	
	public static WebDriver createDriver() {
		// Choose driver
		switch (Config.browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", Config.chromeDriverPath);
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", Config.firefoxDriverPath);
			driver = new ChromeDriver();
			break;
		}

		// Implicity wait for general driver control
		driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT_DEFAULT_TIME, TimeUnit.SECONDS);

		// WebDriver setup
		driver.manage().window().maximize();
		
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
