package tests;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pages.JsonPage;

public class BaseTest {
	public static JsonPage jsonHelper;
	public static AppiumDriver<MobileElement> driver = null;
	private static AppiumDriverLocalService server;

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

	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
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

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
