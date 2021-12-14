package tests;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {


	public static AppiumDriver<MobileElement> driver;
	private static AppiumDriverLocalService server;

	public BaseClass(AppiumDriver<MobileElement> driver) {
		// TODO Auto-generated constructor stub
	}

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	@BeforeSuite
	public void beforeSuite() throws Exception, Exception {

		server = getAppiumServerDefault();
		if (!checkIfAppiumServerIsRunnning(4723)) {
			server.start();
			server.clearOutPutStreams();
			System.out.println("Appium server started");

		} else {
			System.out.println("Appium server already running");
		}
	}

	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			System.out.println("1");
			isAppiumServerRunning = true;
		} finally {
			socket = null;
		}
		return isAppiumServerRunning;
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		if (server.isRunning()) {
			server.stop();

		}
	}

	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	@BeforeTest
	public void setup() {

		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "android");
			caps.setCapability("platformVersion", "9.1.0");
			caps.setCapability("deviceName", "SAMSUNG prime");
			caps.setCapability("udid", "QDT4C17C11006399");
			caps.setCapability("newCommandTimeout", "60");
			caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/apps/android_build.apk");
			caps.setCapability("appPackage", "com.ecomapp");
			caps.setCapability("appActivity", "com.ecomapp.MainActivity");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);

		} catch (Exception e) {
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public AndroidElement getListElement(String elementName, List<MobileElement> loginButton){

		for(int i=0; i<loginButton.size();i++) {

			if (loginButton.get(i).getText().contains(elementName)) {
				System.out.println("*Got* " + loginButton.get(i).getText());
				return (AndroidElement) loginButton.get(i);
			}
		}
		return null;
	}

	

	public void clear(MobileElement e) {
		
		e.clear();
	}

	

	public void openNotifications() {

		((AndroidDriver<MobileElement>) getDriver()).openNotifications();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public static void clickBackButton() {
		// TODO Auto-generated method stub
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
