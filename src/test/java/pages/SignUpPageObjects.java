package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpPageObjects {

	@AndroidFindBy(id = "logoImage")
	public MobileElement ecomAppLogo;

	@AndroidFindBy(id = "titleText")
	public MobileElement signUpTitle;

	@AndroidFindBy(id = "signup")
	public MobileElement signUpButton;

	@AndroidFindBy(id = "name")
	public MobileElement userFirstName;

	@AndroidFindBy(id = "name1")
	public MobileElement userLastName;

	@AndroidFindBy(id = "mail")
	public MobileElement userMailId;

	@AndroidFindBy(id = "pass")
	public MobileElement validPassword;

	@AndroidFindBy(id = "phone")
	public MobileElement phoneNumber;

	@AndroidFindBy(id = "termsAndServices")
	public MobileElement termsOfServices;

}
