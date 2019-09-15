package sep14;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import day3.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	protected WebDriver driver;

	@BeforeClass
	public void openBrowser() throws IOException {
		if (Utils.getValue("env").equalsIgnoreCase("mac") && Utils.getValue("browser").equalsIgnoreCase("chrome")) {
			// String path = Utils.getValue("cpath");
			// System.setProperty("webdriver.chrome.driver", path);
			ChromeOptions ops =  new ChromeOptions();
			ops.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver(ops);
		} else if (Utils.getValue("env").equalsIgnoreCase("windows")
				&& Utils.getValue("browser").equalsIgnoreCase("chrome")) {
			String path = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
		} else if (Utils.getValue("env").equalsIgnoreCase("mac")
				&& Utils.getValue("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			 
		}
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void close() {

		driver.quit();
	}

}
