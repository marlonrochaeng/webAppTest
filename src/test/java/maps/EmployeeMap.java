package maps;

import org.openqa.selenium.By;

public class EmployeeMap {
	public By nameField = By.id("inputNome");
	public By cpfField = By.id("cpf");
	public By sexField = By.id("slctSexo");
	public By admissionDateField = By.id("inputAdmissao");
	public By roleField = By.id("inputCargo");
	public By salaryField = By.id("dinheiro");
	public By cltRadio = By.id("clt");
	public By pjRadio = By.id("pj");
	public By submitButton = By.className("cadastrar-form-btn");
	public By cancelButton = By.className("cancelar-form-btn");
}
