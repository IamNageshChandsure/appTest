package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.SignInPage;
import pages.SignUpPageObjects;
@Test(groups = { "ClassTest1" })
public class SignInTest extends BaseClass {
	SignInPage userCredential;
	String testUser = "nchandsure@gmail.com";
	String password = "Test@12345";

	public SignInTest(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SignUpPageObjects signUpPageObjects = new SignUpPageObjects();

	@Test(priority = 1, description = "Signup User and login", groups = "All")
	public void signInTest() throws InterruptedException {
		userCredential = new SignInPage(BaseClass.driver);
		boolean result = userCredential.login(testUser, password);
		AssertJUnit.assertTrue("User could not Signup", result == true);
	}

	@Test(priority = 2, description = "Logout User after Signup", groups = "All")
	public void logoutTestAfterSignIn() throws InterruptedException {
		userCredential = new SignInPage(BaseClass.driver);
		boolean loggedOut = userCredential.logout();
		AssertJUnit.assertTrue("User could not logout", loggedOut == true);
	}

}
