package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import maps.EmployeeMap;
import maps.LoginMap;
import maps.RegisterMap;

public class EmployeePage extends BasePage{
	
	EmployeeMap employeeMap = new EmployeeMap();
	Faker faker = new Faker();
	String userName = faker.name().firstName() + " " + faker.name().lastName();
	String FAKE_CPF = "177.043.310-43";
	String ROLE = "QA";
	String SALARY = "10000";
	String SEX = "Indiferente";
	public EmployeePage(WebDriver driver) {
		super(driver);
	}

	
	public void createNewBasicEmployee() {
		this.sendKeys(employeeMap.nameField, userName);
		this.sendKeys(employeeMap.cpfField, FAKE_CPF);
		this.sendKeys(employeeMap.admissionDateField, "10/11/2019");
		this.sendKeys(employeeMap.roleField, ROLE);
		this.sendKeys(employeeMap.salaryField, SALARY);
		this.javascriptClick(employeeMap.pjRadio);
		this.selectByText(employeeMap.sexField, SEX);
		this.javascriptClick(employeeMap.submitButton);
	}
	
	public void editEmployeeName() {
		this.clearField(employeeMap.nameField);
		this.sendKeys(employeeMap.nameField, userName);
		this.javascriptClick(employeeMap.submitButton);
	}
	
	

}
