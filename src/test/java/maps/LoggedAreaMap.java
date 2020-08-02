package maps;

import org.openqa.selenium.By;

public class LoggedAreaMap {
	public By employeeButton = By.xpath("//a[@href='/empregados/']");
	public By newEmployeeButton = By.xpath("//a[@href='/empregados/new_empregado']");
	public By logoutButton = By.xpath("//a[contains(text(),'Sair')]");
	public By searchBar = By.xpath("//input[@type='search']");
	public By deleteButton = By.id("delete-btn");
	public By editButton = By.xpath("//button[contains(@class,'btn btn-warning')]");
	public By alert = By.xpath("//div[contains(@class,'alert')]");
}
