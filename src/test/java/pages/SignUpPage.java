package pages;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import tests.BaseClass;

public class SignUpPage extends BaseClass {
	
		

	public SignUpPage(AppiumDriver<MobileElement> driver) {
		super(driver);

	}

	public SignUpPageObjects signUpPageObjects = new SignUpPageObjects();

	public void verifyElemntsOnPageTest() {

		signUpPageObjects.ecomAppLogo.isDisplayed();

		signUpPageObjects.signUpTitle.isDisplayed();

		signUpPageObjects.signUpButton.isDisplayed();

	}

	public void registrationTest() {

		clear(signUpPageObjects.userFirstName);
		signUpPageObjects.userFirstName.sendKeys("Nagesh");

		clear(signUpPageObjects.userLastName);
		signUpPageObjects.userLastName.sendKeys("Chandsure");

		clear(signUpPageObjects.userMailId);
		signUpPageObjects.userMailId.sendKeys("nchandsure@gmail.com");

		clear(signUpPageObjects.validPassword);
		signUpPageObjects.validPassword.sendKeys("Test@12345");

		clear(signUpPageObjects.phoneNumber);
		signUpPageObjects.phoneNumber.sendKeys("9021823598");

		signUpPageObjects.termsOfServices.click();

		signUpPageObjects.signUpButton.click();
	}
	
	
	

}
