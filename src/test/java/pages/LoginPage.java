package pages;

import org.openqa.selenium.WebDriver;

import maps.LoginMap;

public class LoginPage extends BasePage{
	
	LoginMap loginMap = new LoginMap();
	
	String RIGHT_USER = "teste_usr1";
	String WRONG_USER = "teste";
	String PASSWORD = "testesenha";


	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToHomePage() {
		this.goToURL("http://www.inmrobo.tk/accounts/login/");
	}
	
	public void goToRegisterPage() {
		this.clickOn(loginMap.registerButton);
	}
	
	public boolean isInLoginPage() {
		try {
			return this.getElementText(loginMap.formTitle).contains("Login");
		} catch (Exception e) {
			System.out.println("Login element not found");
			return false;
		}
	}
	
	public void login(boolean flag) {
		if(flag) {
			this.sendKeys(loginMap.usernameField, RIGHT_USER);
		}
		else {
			this.sendKeys(loginMap.usernameField, WRONG_USER);
		}
		
		this.sendKeys(loginMap.passwordField, PASSWORD);
		this.javascriptClick(loginMap.enterButton);
	}
	
	public boolean isErrorMessageDisplayed(String error) {
		this.forcedWait(1);
		return this.getText(loginMap.alert).contains(error);
	}
	

}
