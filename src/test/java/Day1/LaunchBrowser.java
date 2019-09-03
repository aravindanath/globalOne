package Day1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import day3.Utils;

public class LaunchBrowser {
	protected WebDriver driver;

	@BeforeClass
	public void beforeSuite() throws IOException {
		if (Utils.getValue("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Utils.getValue("cpath"));
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
			// System.err.println(" ========== Connect to db ========== ");
		} else if (Utils.getValue("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Utils.getValue("fpath"));
			driver = new FirefoxDriver();
			driver.manage().window().fullscreen();
			// System.err.println(" ========== Connect to db ========== ");
		}

	}

	// @AfterSuite
	// public void OpenBrowser() {
	// System.err.println(" ========== close db ========== ");
	// }

	@AfterClass
	public void close() {
		driver.close();
		System.err.println("close Browser");
	}

}
