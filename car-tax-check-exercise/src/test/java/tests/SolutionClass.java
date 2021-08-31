package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;


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
	public void carTaxCheckTest() throws FileNotFoundException {
		
		//Set path to csv file to fetch car registration numbers
		String csv_path = projectPath+"\\src\\test\\resources\\car_registration_numbers.csv";
		//Create an object of CSVReader to link to above csv
		CSVReader csvReader = new CSVReader(new FileReader(csv_path));
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}
	
	
	

}
