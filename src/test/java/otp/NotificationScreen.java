package otp;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.Assert;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import tests.BaseClass;

public class NotificationScreen extends BaseClass{

	public NotificationScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public EnterPhoneNumberScreen clearNotification() throws InterruptedException {

		openNotifications();
		try {
			AndroidElement notif = (AndroidElement) driver.findElementById("Notification");
			
			if (notif.isDisplayed()) {
				notif.click();
				return new EnterPhoneNumberScreen(driver);
			} else if(!notif.isEnabled()) {
				System.out.println("No notifications to clear, going back");
				clickBackButton();
				return new EnterPhoneNumberScreen(driver);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("No notifications to clear, going back");
			clickBackButton();
		}
		return new EnterPhoneNumberScreen(driver);
	}

	private String OTPloop(int size, List<MobileElement> messageText) {
		System.out.println("Inside OTP Loop method");
		for (int i = 0; i < size; i++) {
			System.out.println("Current position = " + i);
			if (messageText.get(i).getText().contains("is the OTP")) {
				return messageText.get(i).getText();
			}
		}
		return "";
	}

	private String extractOTP(String OTP) {
		
		Pattern p = Pattern.compile("\\=+");
		Matcher m = p.matcher(OTP);
		
		while(m.find()) {

			System.out.println(m.group().length());
			System.out.println(m.group());

			if(m.group().length()==4) {
				System.out.println("The OTP is: " + m.group());
				return m.group();
			}
		}return "";
	}


	public String getOTP() throws InterruptedException {

		String OTP = new String();	
		try {
		openNotifications();

		Thread.sleep(3000);

		List<MobileElement> messageText = driver.findElements(By.className("android.widget.TextView"));
		int Size = messageText.size();
		System.out.println("Size =" + Size);

		for(int i=0; i<=3; i++) {
			
			Thread.sleep(2000);
			if(OTP.length()==0) {
				OTP = OTPloop(Size, messageText);
			}else {
				System.out.println("Found the OTP, Yay!!!");
				break;
			}
		}	

		if(OTP.length()<4) {
			
			clickBackButton();
			
		}else {
			OTP = extractOTP(OTP);
		}
		
		if(OTP.length()==0) {
			Assert.fail("OTP not received");
		}else {

			System.out.println("OTP is: " +  OTP);
		}
		
		clickBackButton();

		System.out.println("");
		System.out.println("---------- Exiting getOTP ----------");
		
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return OTP;
	}

}
