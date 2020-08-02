package maps;

import org.openqa.selenium.By;

public class LoginMap {
	public By usernameField = By.name("username");
	public By passwordField = By.name("pass");
	public By enterButton = By.xpath("//button[contains(text(),'Entre')]");
	public By registerButton = By.xpath("//a[@class='txt2 bo1']");
	public By formTitle = By.xpath("//span[@class='login100-form-title p-b-1']");
	public By alert = By.xpath("//div[contains(@class,'alert')]");
}
