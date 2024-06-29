package PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "(//input[@type='email'])[1]")
	private WebElement emailId;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement Password;
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your password?111")
	private WebElement forgotPwdLink;

	@FindBy(xpath = "//a[contains(text(),\"Logout\")]")
	private WebElement logout;
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	private WebElement SignUplogin;

	@FindBy(xpath = "//button[contains(text(), \"Login\")]")
	private WebElement login;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
	private WebElement loginGetText;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void signInButton() {
		signInButton.click();
	}

	public void loginPage1() {
		loginGetText.getText();
	}

	public void enterEmail(String email) {
		emailId.sendKeys(email);

	}

	public void enterPassWord(String password) {
		Password.sendKeys(password);
	}
	public void loginbuttonclick() {
		login.click();
	}

	public void clickOnLogout() {
		logout.click();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
