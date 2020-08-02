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
	
	public String getElementText(By locator) {
		//colocar var estatica no 30
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}
	
	public void javascriptClick(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

	}
	
	public String getAttr(By locator,String attr) {
		return driver.findElement(locator).getAttribute(attr);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void selectByText(By locator, String text) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(text);
	}
	
	public void clearField(By locator) {
		driver.findElement(locator).clear();
	}

}
