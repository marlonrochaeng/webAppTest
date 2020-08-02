package steps;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterSteps{
	
	LoginPage loginPage;
	RegisterPage registerPage;
	
	public RegisterSteps() {
		loginPage = new LoginPage(getDriver());
		registerPage = new RegisterPage(getDriver());
	}
	
	@Given("^I open the browser in homepage$")
	public void iOpenTheBrowserInHomepage() throws Throwable {
		System.out.println("Open browser in homepage");
		loginPage.goToHomePage();
	}

	@Given("^navigate to register page$")
	public void navigateToRegisterPage() throws Throwable {
		System.out.println("navigate to register page");
		loginPage.goToRegisterPage();
	}

	@When("^I try to create a new user with valid information$")
	public void iTryToCreateANewUserWithValidInformation() throws Throwable {
		System.out.println("I try to create a new user with valid information");
		registerPage.createNewUser(true);
	}

	@Then("^I should be redirected to login page$")
	public void iShouldBeRedirectedToLoginPage() throws Throwable {
		System.out.println("I should be redirected to login page");
		assertTrue(loginPage.isInLoginPage());
	}

	@When("^I try to create a new user with invalid username$")
	public void iTryToCreateANewUserWithInvalidUsername() throws Throwable {
		System.out.println("I try to create a new user with invalid username");
		registerPage.createNewUser(false);
	}

	@Then("I should not be redirected to login page$")
	public void iShouldSeeATooltipInformingTheError() throws Throwable {
		assertFalse(loginPage.isInLoginPage());
	}

}
