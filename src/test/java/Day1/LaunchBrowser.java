package Day1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import day3.Utils;

public class LaunchBrowser {
	protected WebDriver driver;

	@BeforeClass
	public void beforeSuite() throws IOException {
		if (Utils.getValue("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Utils.getValue("cpath"));
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(ops);
			driver.manage().window().fullscreen();
			// System.err.println(" ========== Connect to db ========== ");
		} else if (Utils.getValue("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Utils.getValue("fpath"));
			FirefoxOptions ops =  new FirefoxOptions();
			ops.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(ops);
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
