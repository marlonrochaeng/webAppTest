package pages;

import org.openqa.selenium.WebDriver;

import maps.LoggedAreaMap;
import maps.LoginMap;

public class LoggedAreaPage extends BasePage{
	
	LoggedAreaMap loggedAreaMap = new LoggedAreaMap();
	String CPF = "177.043.310-43";

	public LoggedAreaPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isLogged() {
		return this.isElementDisplayed(loggedAreaMap.employeeButton);
	}
	
	public void goToNewEmployee() {
		this.javascriptClick(loggedAreaMap.newEmployeeButton);
	}
	
	public boolean isEmployeeCreated(String message) {
		this.forcedWait(1);
		return this.getText(loggedAreaMap.alert).contains(message);
	}
	
	public void searchAndEdit() {
		this.clearField(loggedAreaMap.searchBar);
		this.sendKeys(loggedAreaMap.searchBar,CPF);
		this.javascriptClick(loggedAreaMap.editButton);
	}
	
	public void searchAndDelete() {
		this.forcedWait(2);
		this.driver.navigate().refresh();
		this.clearField(loggedAreaMap.searchBar);
		this.sendKeys(loggedAreaMap.searchBar,CPF);
		this.javascriptClick(loggedAreaMap.deleteButton);
	}
}
