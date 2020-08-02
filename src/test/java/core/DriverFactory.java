package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("headless");
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--remote-debugging-port=9222");
			
			chromeOptions.setBinary(Config.chromeDriverPath);
			driver = new ChromeDriver(chromeOptions);
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
