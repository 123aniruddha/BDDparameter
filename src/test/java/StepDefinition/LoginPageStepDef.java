package StepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import UtilsLayer.UtilClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef extends BaseClass {
	private WebDriver driver;
	private static String loginTitle;
	private LoginPage loginPage;

	@Before
	public void setUp() throws IOException {
		initialization();
		driver = BaseClass.driver;
		loginPage = new LoginPage(driver);
	}

	@Given("User launch a browser")
	public void user_launch_a_browser() throws IOException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
	}

	@When("user click on Login Button")
	public void user_click_on_login_button() {
		loginPage.signInButton();
	}

	@Then("user is on Login page")
	public void user_is_on_login_page() {
		loginPage.loginPage1();
	}

	@When("user enter email {string} and password {string}")
	public void user_enter_email_and_password(String email, String password) {
		loginPage.enterEmail(email);
		loginPage.enterPassWord(password);
	}

	@Then("click on Login button")
	public void click_on_login_button() {
		loginPage.loginbuttonclick();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		String ExpectedTitle = expectedTitleName;
		System.out.println("Expected Title " + expectedTitleName);

		String loginTitle = driver.getTitle();
		System.out.println("Title is " + loginTitle);
		Assert.assertTrue(loginTitle.equalsIgnoreCase(ExpectedTitle));
	}

	@And("user verify logout button")
	public void userVerifyLogoutButton() {
		loginPage.clickOnLogout();

	}

	@And("User close a browser")
	public void userCloseABrowser() throws IOException {
		loginPage.quitBrowser();
	}

}
