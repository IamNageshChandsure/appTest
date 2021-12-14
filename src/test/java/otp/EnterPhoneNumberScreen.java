package otp;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import tests.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class EnterPhoneNumberScreen extends BaseClass {

	public EnterPhoneNumberScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	private void goToEnterPhoneNumberTextBox() {
		try {
			AndroidElement enterMobile = (AndroidElement) driver.findElement(By.id("inputs"));
			if (enterMobile.isDisplayed()) {
				enterMobile.click();
			}
		} catch (NoSuchElementException e) {

			System.out.println("Enter Mobile NO. not displayed, are you on the right page?");
		}
	}

	private String whichScreen() {

		try {
			if (driver.findElement(By.id("com.makemytrip:id/inputs_content")).isDisplayed()) {
				System.out.println();
				System.out.println("Found Screen 1");
				return "1";
			}
		} catch (NoSuchElementException e) {
			System.out.println();
			System.out.println("Screen 1 not displayed " + e);
		}

		try {

			if (driver.findElement(By.id("com.makemytrip:id/btn_login")).isDisplayed()) {
				System.out.println();
				System.out.println("Found Screen 2");
				return "2";
			}
		} catch (NoSuchElementException e) {
			System.out.println();
			System.out.println("Screen 2 not displayed " + e);
		}

		try {

			if (driver.findElement(By.id("com.makemytrip:id/bb_home")).isDisplayed()) {
				System.out.println();
				System.out.println("Found Screen 3");
				return "3";
			}
		} catch (NoSuchElementException e) {
			System.out.println();
			System.out.println("Screen 3 not displayed " + e);
		}

		try {

			if (driver.findElement(By.id("com.makemytrip:id/loginButton")).isDisplayed()) {
				System.out.println();
				System.out.println("Found Screen 4");
				return "4";
			}
		} catch (NoSuchElementException e) {
			System.out.println();
			System.out.println("Screen 4 not displayed " + e);
		}
		return "";
	}

	public EnterPhoneNumberScreen enterPhoneNumber(String phNumber) {

		switch (whichScreen()) {
		case "1":
			goToEnterPhoneNumberTextBox();
			break;

		case "2":
			driver.findElement(By.id("com.makemytrip:id/btn_login")).click();
			break;

		case "3":
			AndroidElement mmtButton = (AndroidElement) driver.findElement(By.id("com.makemytrip:id/my_profile_icon"));
			mmtButton.click();
			List<MobileElement> loginButton = driver.findElements(By.className("android.widget.TextView"));
			AndroidElement login = getListElement("LOGIN", loginButton);
			login.click();
			break;

		case "4":
			driver.findElement(By.id("loginButton")).click();
			break;

		default:
			System.out.println("None of the expected screens were displayed");
			break;
		}
		AndroidElement phNo = (AndroidElement) driver.findElement(By.className("PEdit"));
		if (phNo.isDisplayed()) {

			phNo.sendKeys(phNumber);
		}
		return this;
	}

	public EnterOTPScreen clickSubmitButton() {

		try {
			AndroidElement button = (AndroidElement) driver.findElement(By.id("Next"));
			button.click();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

		try {
			AndroidElement createNewAccount = (AndroidElement) driver
					.findElement(By.id("CreateAcc"));

			if (createNewAccount.isDisplayed()) {
				createNewAccount.click();
			} else
				Assert.fail();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}

		return new EnterOTPScreen(driver);

	}
}
