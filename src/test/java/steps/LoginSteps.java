package steps;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoggedAreaPage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginSteps{
	
	LoginPage loginPage;
	LoggedAreaPage loggedAreaPage;
	
	public LoginSteps() {
		loginPage = new LoginPage(getDriver());
		loggedAreaPage = new LoggedAreaPage(getDriver());
	}
	
	@Given("^try to login with the right information$")
	public void tryToLoginWithTheRightInformation() throws Throwable {
		loginPage.login(true);
	}

	@Then("^I should be redirected to the logged area$")
	public void iShouldBeRedirectedToTheLoggedArea() throws Throwable {
		assertTrue(loggedAreaPage.isLogged());
	}
	
	@Given("^try to login with the wrong information$")
	public void tryToLoginWithTheWrongInformation() throws Throwable {
		loginPage.login(false);
	}

	@Then("^I should be able to see the \"([^\"]*)\" alert$")
	public void iShouldBeAbleToSeeTheAlert(String arg1) throws Throwable {	
		assertTrue(loginPage.isErrorMessageDisplayed(arg1));
	}

}
