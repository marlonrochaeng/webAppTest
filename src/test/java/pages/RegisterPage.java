package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.Faker;

import maps.LoginMap;
import maps.RegisterMap;

public class RegisterPage extends BasePage{
	
	RegisterMap registerMap = new RegisterMap();
	Faker faker = new Faker();
	String userName = faker.name().firstName() + faker.name().lastName();
	String wrongUserName = "test";
	String PASSWORD = "test12345";
	


	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	
	public void createNewUser(boolean flag) {
		if(flag) {
			this.sendKeys(registerMap.usernameField, userName);
		}
		else {
			this.sendKeys(registerMap.usernameField, wrongUserName);
		}
		this.sendKeys(registerMap.passwordField, PASSWORD);
		this.sendKeys(registerMap.confirmPassField, PASSWORD);
		this.javascriptClick(registerMap.registerButton);
	}


}
