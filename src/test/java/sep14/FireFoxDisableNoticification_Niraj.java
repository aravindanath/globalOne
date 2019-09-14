package sep14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDisableNoticification_Niraj {

	public WebDriver driver;

	@Test
	public void Login() {

		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options);
		driver.get("https://www.icicibank.com//");
		driver.manage().window().maximize();
		driver.close();
	}

//	@Test
//	public void OldLogin() {
//
//		FirefoxOptions options = new FirefoxOptions();
//		options.addPreference("dom.webnotifications.enabled", false);
//		System.setProperty("webdriver.gecko.driver", "D:\\GITBASH\\New GIT Projects\\globalOne\\driver\\geckodriver.exe");
//		driver = new FirefoxDriver(options);
//		driver.get("https://www.icicibank.com//");
//		driver.manage().window().maximize();
//		driver.close();
//	}
}
