package maps;

import org.openqa.selenium.By;

public class RegisterMap {
	public By usernameField = By.name("username");
	public By passwordField = By.name("pass");
	public By confirmPassField = By.name("confirmpass");
	public By registerButton = By.xpath("//button[contains(text(),'Cadastrar')]");
}
