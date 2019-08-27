package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * <dependency> <groupId>io.github.bonigarcia</groupId>
 * <artifactId>webdrivermanager</artifactId> <version>3.6.2</version>
 * <scope>test</scope> </dependency>
 * https://github.com/bonigarcia/webdrivermanager
 * 
 * @author aravindanathdm
 *
 */

public class LaunchBrowserWebDrivermanger {
	WebDriver driver;
	String browser = "firefox";

	@BeforeTest
	public void launchBrowser() {
		if (browser == "chrome") {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(ops);
		} else if (browser == "firefox") {
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		}
	}

	@Test
	public void test() {
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
