package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class LaunchBrowser {
	protected WebDriver driver;
	
	@BeforeClass
	public void beforeSuite() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/aravindanathdm/Documents/Aravinda/chromedriver");
		driver =  new ChromeDriver();
		
		System.err.println(" ========== Connect to db ========== ");
	}
	

	@AfterSuite
	public void OpenBrowser() {
		System.err.println(" ========== close db ========== ");
	}
	

	@AfterClass
	public void close() {
		driver.close();
		System.err.println("close Browser");
	}

}
