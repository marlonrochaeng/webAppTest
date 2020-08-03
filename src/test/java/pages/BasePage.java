package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	protected WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * The command opens the specified URL 
	 * @param url
	 */
	public void goToURL(String url) {
		driver.get(url);
		wait = new WebDriverWait(driver, 30);
	}
	
	/**
	 * Waits for element to be clickable and clicks on it
	 * @param locator
	 */
	public void clickOn(By locator) {
		try {
			System.out.println("waiting for button to be clickable...");
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

			element.click();
			System.out.println("Button clicked...");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Waits for element to be clickable and send keys to it
	 * @param locator
	 * @param text
	 */
	public void sendKeys(By locator, String text) {
		WebElement element = driver.findElement(locator);
		
		element.sendKeys(text);
		System.out.println("Text sent...");
	}
	
	/**
	 * Verify if element is displayed 
	 * @param locator
	 * @return boolean
	 */
	public boolean isElementDisplayed(By locator) {
		return (driver.findElements(locator).size() != 0);
	}
	
	/**
	 * Waits for the @param in seconds with a tread.sleep function
	 * @param time
	 */
	public void forcedWait(int time) {
		try {
			System.out.println("Waiting for %d seconds..."+time);
			Thread.sleep(time*1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Returns element text using explicitly wait
	 * @param locator
	 * @return
	 */
	public String getElementText(By locator) {
		//colocar var estatica no 30
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}
	
	/**
	 * Use javascript executor to perform a click
	 * @param locator
	 */
	public void javascriptClick(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

	}
	
	/**
	 * Get element attribute 
	 * @param locator
	 * @param attr
	 * @return
	 */
	public String getAttr(By locator,String attr) {
		return driver.findElement(locator).getAttribute(attr);
	}
	
	/**
	 * Returns element text using implicit wait
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	/**
	 * Get page title
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	
	/**
	 * select element by text on select
	 * @param locator
	 * @param text
	 */
	public void selectByText(By locator, String text) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(text);
	}
	
	/**
	 * remove element string (works only on text field)
	 * @param locator
	 */
	public void clearField(By locator) {
		driver.findElement(locator).clear();
	}

}
