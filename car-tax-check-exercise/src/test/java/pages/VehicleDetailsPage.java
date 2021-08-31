package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VehicleDetailsPage {
	private static WebElement element = null;
	
	public static WebElement car_registration(WebDriver driver, String carReg) {
		element = driver.findElement(By.xpath("//dd[contains(text(),'"+carReg+"')]"));
		return element;
	}
	
	public static WebElement car_make(WebDriver driver) {
		element = driver.findElement((By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/span[1]/div[2]/dl[2]/dd[1]")));
		return element;
	}
	
	public static WebElement car_model(WebDriver driver) {
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/span[1]/div[2]/dl[3]/dd[1]"));
		return element;
	}
	
	public static WebElement car_colour(WebDriver driver) {
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/span[1]/div[2]/dl[4]/dd[1]"));
		return element;
	}
	
	public static WebElement car_year(WebDriver driver) {
		element = driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='m']/div[2]/div[5]/div[1]/div[1]/span[1]/div[2]/dl[5]/dd[1]"));
		return element;
	}
	
	public static WebElement header_menu_option(WebDriver driver) {
		element = driver.findElement(By.xpath("//header/div[1]/span[1]"));
		return element;
	}
	
	public static WebElement free_car_check_option(WebDriver driver) {
		element = driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='m']/div[@id='head']/nav[@id='menu']/div[1]/div[1]/a[1]"));
		return element;
	}

}
