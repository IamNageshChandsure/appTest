package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;

public class ProductComponent {
	
	By product = By.xpath("//android.widget.TextView[@text='\"Roadster Men Black Nepped Round Neck T-shirt\"']");
	

		
	protected MobileElement container;
	public ProductComponent(WebDriver driver, WebElement container) {
		super();

		
	}
	
	
	
	
	public String productDetails() {
		return container.findElement(product).getAttribute("text");
	}
	
	
	}
