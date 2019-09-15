package Day1;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import day3.Utils;

public class LaunchBrowser {
	protected WebDriver driver;

	@BeforeClass
	public void beforeSuite() throws IOException {
		if (Utils.getValue("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Utils.getValue("cpath"));
			/**
			 * File download
			 */
			String downloadFilepath = "/Users/aravindanathdm/Desktop";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.setExperimentalOption("prefs", chromePrefs);

			// ops.setHeadless(true);
			ops.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(ops);
			driver.manage().window().fullscreen();
			// System.err.println(" ========== Connect to db ========== ");
		} else if (Utils.getValue("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Utils.getValue("fpath"));
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.dir", "/Users/aravindanathdm/Desktop");
			FirefoxOptions ops = new FirefoxOptions();
			ops.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(ops);
			driver.manage().window().fullscreen();
			// System.err.println(" ========== Connect to db ========== ");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// @AfterSuite
	// public void OpenBrowser() {
	// System.err.println(" ========== close db ========== ");
	// }

	@AfterClass
	public void close() {
		driver.quit();
		System.err.println("close Browser");
	}

}
