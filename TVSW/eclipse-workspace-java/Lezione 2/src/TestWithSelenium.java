import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWithSelenium {

	public static void main(String[] args) {
		// Declaration and instantiation of objects/variables

		/*
		 * System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		 * WebDriver driver = new FirefoxDriver();
		 */

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "http://demo.guru99.com/test/newtours/";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";

		// Launch browser and direct it to the Base URL
		driver.get(baseUrl);

		// Get the actual value of the title
		actualTitle = driver.getTitle();

		/*
		 * Compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		// Close browser
		driver.close();
	}

}