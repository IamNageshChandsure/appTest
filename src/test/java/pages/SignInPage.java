package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tests.BaseClass;

public class SignInPage extends BaseClass {

	By signUp = By.id("SignUpButton");
	By alreadyHaveAccount = By.id("Already_Have_An_Account_Link");
	By newUser = By.id("NewUser");
	By newPwd = By.id("NewPassword");
	By loginUser = By.id("LoginUser");
	By loginPwd = By.id("LoginPassword");
	By loginBtn = By.id("LoginBtn");
	By createBtn = By.id("SubmitNewUserBtn");
	By home = By.id("Home");
	By menu = By.id("Menu");
	By logout = By.id("Logout");

	public boolean login(String userName, String password) throws InterruptedException {
		driver.findElement(signUp).click();
		if (driver.findElements(alreadyHaveAccount).size() > 0)
			driver.findElement(alreadyHaveAccount).click();
		driver.findElement(loginUser).sendKeys(userName);
		driver.findElement(loginPwd).sendKeys(password);
		driver.findElement(loginBtn).click();
		return driver.findElement(home).isDisplayed();
	}

	public boolean logout() throws InterruptedException {
		driver.findElement(menu).click();
		driver.findElement(logout).click();
		return driver.findElement(signUp).isDisplayed();
	}

	public SignInPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
