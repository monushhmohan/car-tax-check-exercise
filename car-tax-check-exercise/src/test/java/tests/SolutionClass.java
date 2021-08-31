package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SolutionClass {
	private WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void testSetUp() {
		System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/browserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://cartaxcheck.co.uk/");
	}
	
	@Test
	public void carTaxCheckTest() {
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}
	
	
	

}
