package com.qa.stepDefination;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class HomePageSteps extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Given("^user opens browser$")
	public void user_opens_browser() {
		TestBase.intialization();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() {
		loginpage = new LoginPage();
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	@When("^user logs into app$")
	public void user_enters_username_and_password()  {
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Then("^validate Home page title$")
	public void validate_Home_page_title()  {
		String hometitle = homepage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO",hometitle );//u can pass by excel as well
	}

	@Then("^Validate logged in username$")
	public void validate_logged_in_username()  {
		driver.switchTo().frame("mainpanel");
	    boolean flag = homepage.verifyUserName();
	    Assert.assertTrue(flag);
	    driver.switchTo().defaultContent();
	}
	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	   driver.close();
	}

}
