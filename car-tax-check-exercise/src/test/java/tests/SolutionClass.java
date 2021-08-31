package tests;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import pages.HomePage;
import pages.VehicleDetailsPage;


public class SolutionClass {
	private WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	String[] csvCell;
	String carReg = "null";
	String Make = "null";
	String Model = "null";
	String Colour = "null";
	String Year = "null";

	@BeforeClass
	public void testSetUp() {
		System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/browserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://cartaxcheck.co.uk/");
	}

	@Test
	public void carTaxCheckTest() throws IOException, CsvValidationException, InterruptedException {

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

				//Enter car details in the homepage	
				Thread.sleep(2000);
				HomePage.enterReg_checkbox(driver).click();
				HomePage.enterReg_checkbox(driver).clear();
				HomePage.enterReg_checkbox(driver).sendKeys(carReg);
				HomePage.FreeCarCheck_button(driver).click();
				Thread.sleep(2000);

				//To check if vehicle not found error is displayed
				boolean vnf = driver.getPageSource().toString().contains("Vehicle Not Found");
				ifVehichleNotFound(vnf, myWriter, failWriter, carReg);
			}
			myWriter.close();
			failWriter.close();
		}

	}
	
	//ifVehichleNotFound method
	public void ifVehichleNotFound(boolean vnf, FileWriter myWriter, FileWriter failWriter, String carRegistration ) throws IOException {
		if(vnf)
		{
			System.out.println("Vehicle is not found");
			System.out.println("-------------------------------------");
			failWriter.write(carRegistration);
			failWriter.write("\n");
			driver.findElement(By.xpath("//a[contains(text(),'Try Again')]")).click();
		}
		else
		{
			System.out.println("Vehicle found");

			//Get vehicle details
			carReg = VehicleDetailsPage.car_registration(driver, carReg).getText();
			System.out.println("Registration is: "+ carReg);

			Make = VehicleDetailsPage.car_make(driver).getText();
			System.out.println("Make is: "+ Make);

			Model = VehicleDetailsPage.car_model(driver).getText();
			System.out.println("Model is: "+ Model);

			Colour = VehicleDetailsPage.car_colour(driver).getText();
			System.out.println("Colour is: "+ Colour);
			
			Year = VehicleDetailsPage.car_year(driver).getText();
			System.out.println("Year is: "+ Year);	
			
			//Write vehicle details into vehicledetails.csv
			String str = carReg.concat(",").concat(Make).concat(",").concat(Model).concat(",").concat(Colour).concat(",").concat(Year);			
			myWriter.write(str);
			myWriter.write("\n");

			System.out.println("-------------------------------------");

			//Go back to homepage
			VehicleDetailsPage.header_menu_option(driver).click();
			VehicleDetailsPage.free_car_check_option(driver).click();
		}
	}
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
}
