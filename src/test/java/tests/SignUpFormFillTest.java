package tests;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
@Test(groups = { "ClassTest1" })
public class SignUpFormFillTest extends BaseClass {

	@Test(priority = 1)
	public void nullNameTest() {
		driver.findElement(MobileBy.id("Sign Up")).click();
		System.out.println("Starting test for blank mobile number...");
		driver.findElementById("Name").sendKeys("");
		driver.hideKeyboard();
		driver.findElementById("Accept_terms").click();
		driver.findElementById("SignUp").click();
		String message = driver.getPageSource();
		if (message.contains("Please fill all the fields")) {
			System.out.println("Test Passed...");
		}
	}

	@Test(priority = 2)
	public void nullLastNameTest() {
		driver.findElement(MobileBy.id("Sign Up")).click();
		System.out.println("Starting test for blank mobile number...");
		driver.findElementById("Name").sendKeys("Nagesh");
		driver.hideKeyboard();
		driver.findElementById("LastName").sendKeys("");
		driver.findElementById("Accept_terms").click();
		driver.findElementById("SignUp").click();
		String message = driver.getPageSource();
		if (message.contains("Please fill the last name ")) {
			System.out.println("Test Passed...");
		}
	}

	@Test(priority = 3)
	public void invalidMobileTest() {
		System.out.println("Starting test for invalid mobile number...");
		driver.findElementById("Name").sendKeys("Nagesh");
		driver.hideKeyboard();
		driver.findElementById("LastName").sendKeys("Chandsure");
		driver.hideKeyboard();
		driver.findElementById("Phone").sendKeys("12345");
		driver.hideKeyboard();
		driver.findElementById("Accept_terms").click();
		driver.findElementById("SignUp").click();
		String message = driver.getPageSource();
		if (message.contains("Please make sure the mobile number you entered is valid")) {
			System.out.println("Test Passed...");
		}
	}

	@Test(priority = 4)
	public void nullEmailTest() {
		System.out.println("Starting test for blank email...");
		driver.findElementById("Name").sendKeys("Nagesh");
		driver.hideKeyboard();
		driver.findElementById("LastName").sendKeys("Chandsure");
		driver.hideKeyboard();
		driver.findElementById("Phone").sendKeys("9021823598");
		driver.hideKeyboard();
		driver.findElementById("Email").sendKeys("");
		driver.hideKeyboard();
		driver.findElementById("Accept_terms").click();
		driver.findElementById("SignUp").click();
		String message = driver.getPageSource();
		if (message.contains("Please fill the email")) {
			System.out.println("Test Passed...");
		}
	}

	@Test(priority = 5)
	public void emailSymbolTest() {
		System.out.println("Starting test for invalid email...");
		driver.findElementById("Name").sendKeys("Nagesh");
		driver.hideKeyboard();
		driver.findElementById("LastName").sendKeys("Chandsure");
		driver.hideKeyboard();
		driver.findElementById("Phone").sendKeys("9021823598");
		driver.hideKeyboard();
		driver.findElementById("Email").sendKeys("nchandsuregmail.com");
		driver.hideKeyboard();
		driver.findElementById("Accept_terms").click();
		driver.findElementById("SignUp").click();

		String message = driver.getPageSource();
		if (message.contains("Please enter a valid email address")) {
			System.out.println("Test Passed...");
		}
	}

	@Test(priority = 6)
	public void nullPassTest() {
		System.out.println("Starting test for blank password...");
		driver.findElementById("Name").sendKeys("Nagesh");
		driver.hideKeyboard();
		driver.findElementById("LastName").sendKeys("Chandsure");
		driver.hideKeyboard();
		driver.findElementById("Phone").sendKeys("9021823598");
		driver.hideKeyboard();
		driver.findElementById("Email").sendKeys("nchandsure@gmail.com");
		driver.hideKeyboard();
		driver.findElementById("Password").sendKeys("");
		driver.hideKeyboard();
		driver.findElementById("Accept_terms").click();
		driver.findElementById("SignUp").click();

		String message = driver.getPageSource();
		if (message.contains("Please enter the password ")) {
			System.out.println("Test Passed...");
		}
	}

	@Test(priority = 7)
	public void dupMobileTest() throws InterruptedException {
		System.out.println("Starting test for duplicate mobile number...");
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

		String message = driver.getPageSource();
		if (message.contains("This phone number is already taken. Kindly try another one")) {
			System.out.println("Test Passed...");
		}
	}

	public SignUpFormFillTest(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
