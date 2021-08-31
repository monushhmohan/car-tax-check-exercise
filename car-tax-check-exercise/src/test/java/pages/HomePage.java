package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage {

	private static WebElement element = null;

	public static WebElement enterReg_checkbox(WebDriver driver) {		
		element = driver.findElement(By.id("vrm-input"));
		return element;

	}

	public static WebElement FreeCarCheck_button(WebDriver driver) {		
		element  = driver.findElement(By.xpath("//div[@id='m']/div[2]/div/div/div/div/form/button"));	
		return element;
	}

}

