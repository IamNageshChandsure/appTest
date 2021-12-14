package otp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import tests.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class EnterOTPScreen extends BaseClass {

	public EnterOTPScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public EnterOTPScreen enterOTP(String otp) {

		try {
			AndroidElement otpBox = (AndroidElement) driver.findElement(By.id("otp_edit"));
			if (otpBox.isDisplayed()) {
				if (otp != null) {
					otpBox.sendKeys(otp);
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println("OTP textbox not displayed");
		}
		return this;
	}

	public void clickSubmitButton() {
		AndroidElement submitButton = (AndroidElement) driver.findElements(By.id("Submit"));
		submitButton.click();
	}
}
