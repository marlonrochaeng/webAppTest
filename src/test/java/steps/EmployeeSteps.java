package steps;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmployeePage;
import pages.LoggedAreaPage;
import pages.LoginPage;
import pages.RegisterPage;

public class EmployeeSteps{
	
	LoginPage loginPage;
	LoggedAreaPage loggedAreaPage;
	EmployeePage employeePage;
	
	public EmployeeSteps() {
		loginPage = new LoginPage(getDriver());
		loggedAreaPage = new LoggedAreaPage(getDriver());
		employeePage = new EmployeePage(getDriver());
	}
	
	@Given("^Im logged in$")
	public void imLoggedIn() throws Throwable {
		loginPage.goToHomePage();
		loginPage.login(true);
	}

	@Given("^I create a new employee$")
	public void iCreateANewEmployee() throws Throwable {
		loggedAreaPage.goToNewEmployee();
		employeePage.createNewBasicEmployee();
	}

	@Then("^I should be able to see the success alert \"([^\"]*)\"$")
	public void iShouldBeAbleToSeeTheSuccessAlert(String arg1) throws Throwable {
	    assertTrue(loggedAreaPage.isEmployeeCreated(arg1));
	}
	
	@When("^I edit an employee name$")
	public void iEditAnEmployeeName() throws Throwable {
		loggedAreaPage.searchAndEdit();
		employeePage.editEmployeeName();
	}
	
	@When("^I delete this employee$")
	public void iDeleteThisEmployee() throws Throwable {
		loggedAreaPage.searchAndDelete();
	}

}
