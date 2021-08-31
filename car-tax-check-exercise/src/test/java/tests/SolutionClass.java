package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class SolutionClass {
	private WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	String[] csvCell;
	String carReg = "null";
	
	@BeforeClass
	public void testSetUp() {
		System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/browserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://cartaxcheck.co.uk/");
	}
	
	@Test
	public void carTaxCheckTest() throws IOException, CsvValidationException {
		
		//Set path to csv file to fetch car registration numbers
		String csv_path = projectPath+"/src/test/resources/car_registration_numbers.csv";
		//Create an object of CSVReader to link to above csv
		CSVReader csvReader = new CSVReader(new FileReader(csv_path));
		
		//Create csv file to write vehicle details e.g. reg no., make, model etc.
		String vd_csv = "src/test/resources/vehicledetails.csv";
		//Create FileWriter object and link to the above vehicle details csv
		FileWriter myWriter = new FileWriter(vd_csv);
		String heading = "REGISTRATION,MAKE,MODEL,COLOR,YEAR\n";
		myWriter.write(heading);
		
		//Create CSV to write incorrect car registrations 
		String fail_csv = "src/test/resources/incorrectCarRegs.csv";
		FileWriter failWriter = new FileWriter(fail_csv);
		failWriter.write("REGISTRATION\n");
		
		//Loop to execute all the car registrations from csv
		while((csvCell = csvReader.readNext()) != null){
			for (int i=0;i<csvCell.length;i++) {
				carReg = csvCell[i];
			}
		}
		
	}


	@AfterTest
	public void tearDown() {
		
	}
	
	
	

}
