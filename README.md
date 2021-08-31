# car-tax-check-exercise
Solution to the car tax check exercise for Automation role.

Framework description:
Solution is developed using Selenium Maven TestNG framework with Java. 

Project dependencies:
1) Selenium, TestNG, OpenCSV libraries
The above libraries are downloaded and installed into the framework using Maven build.

2) Browser driver:
Path to driver: /src/test/resources/browserDriver/geckodriver.exe
Firefox driver has been used in this exercise. 


3) Project resources:
Path to project resources:\src\test\resources
Files received with the exercise e.g. car_input.txt etc. 
CSVs generated on run-time are saved in this location as well.

4) pom.xml
Contains project build information and project dependencies.

5) TestNG plugin
Needed to execute the solution class which is written using TestNG annotations and libraries.

 
Solution:
1) ExtractcarRegNumbers.java 
Path: \src\main\java\ExtractCarRegNumbers.java
This java class script reads the car_input.txt file and extracts the Car registration numbers (only) from this txt file. 
And then writes them into car_registration_numbers.csv which is saved in the project resources directory(Path: \src\test\resources\car_registration_numbers.csv)

2) HomePage.java
This java class script contains html calling objects of the application's Home page only.
Path: \src\test\java\pages\HomePage.java

3)VehicleDetailsPage.java
This java class script contains html calling objects of the application's vehicle details page only.
Path: \src\test\java\pages\VehicleDetailsPage.java

4)SolutionClass.java
This java class is the main script written suing TestNG implementation. Run this to see the output.
Path: \src\test\java\tests\SolutionClass.java

5)Output CVSs:
Below are the 3 output csvs generated on runtime with corresponding data.
car_registration_numbers.csv- Generated with car reg numbers from input txt file.
incorrectCarRegs.csv- Extracts and stores any incorrect reg numbers from the input txt file.
vehicledetails.csv- Stores necessary vehicle details e.g. registration, make, model etc.

Paths to the above files:
\src\test\resources\car_registration_numbers.csv
\src\test\resources\incorrectCarRegs.csv
\src\test\resources\vehicledetails.csv

6)Test report 
Generated after every run, in HTML format.
Path:\test-output\index.html