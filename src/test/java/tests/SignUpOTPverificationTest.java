package tests;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import otp.EnterOTPScreen;
import otp.NotificationScreen; 

@Test(groups = { "ClassTest1" })
public class SignUpOTPverificationTest extends BaseClass{
	
	
	public static EnterOTPScreen enterOTP;
	public static NotificationScreen notification;
	
	@Test(priority = 1)
	public void SubmitingForm() {
		System.out.println("Starting test for verification of mobile otp...");
		driver.findElementById("Name").sendKeys("Nagesh");
		driver.hideKeyboard();
		driver.findElementById("LastName").sendKeys("Chandsure");
		driver.hideKeyboard();
		driver.findElementById("Phone").sendKeys("9021823598");
		driver.hideKeyboard();
		driver.findElementById("Email").sendKeys("nchandsure@gmail.com");
		driver.hideKeyboard();
		driver.findElementById("Password").sendKeys("Test@12345");
		driver.hideKeyboard();
		driver.findElementById("Accept_terms").click();
		driver.findElementById("SignUp").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=2)
	public void enterOTPReceived() throws InterruptedException {

		enterOTP = new EnterOTPScreen(driver);

		String otp = notification.getOTP();

		if(otp.contentEquals("")) {
			System.out.println("Waiting for 20 seconds to manually enter OTP");
			Thread.sleep(20000);
			enterOTP.clickSubmitButton();
		}else {
			enterOTP.enterOTP(otp);
			enterOTP.clickSubmitButton();
		}
	}

	
	

	public SignUpOTPverificationTest(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
}
