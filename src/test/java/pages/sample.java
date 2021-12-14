package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.JSONObject;


import org.openqa.selenium.By;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import tests.BaseTest;

public class sample extends BaseTest {
	By addToCart = By.xpath("//android.view.ViewGroup[@index='3']");
	By goToCart = By.xpath("//android.widget.ImageView[@index='0']");
	ProductComponent page;
	JSONObject config;

	
	
	
	
	
	
	@Test
	public void test1() throws InterruptedException {
		
		driver.findElement(addToCart).click();
		Thread.sleep(3000); // For seeing execution
		driver.findElement(goToCart).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void jsonTest1() throws IOException {

		assertEquals(2310365, config.getJSONObject("products").getString("productId"), 
				"Product Id don't match");
		
		assertEquals(page.productDetails(), config.getJSONObject("products").getString("productName"),
				"Product Name don't match");

	}
}
