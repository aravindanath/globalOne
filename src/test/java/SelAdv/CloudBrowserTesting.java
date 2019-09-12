package SelAdv;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import okhttp3.internal.Version;

public class CloudBrowserTesting {

	private static final String ACCESS_KEY = ".adsfasdf";//0
	private WebDriver driver;
	private URL url;
	private DesiredCapabilities dc = new DesiredCapabilities();
	public String browser = "chrome";

	@BeforeMethod
	public void setUp() throws Exception {

		url = new URL("https://cloud.seetest.io/wd/hub");
		if (browser.equalsIgnoreCase("chrome")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			dc.setCapability(CapabilityType.BROWSER_VERSION,"74.0.3729.169");
		} else if (browser.equalsIgnoreCase("ie")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
		} else if (browser.equalsIgnoreCase("ff")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		} else if (browser.equalsIgnoreCase("edge")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
		}

		dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
		dc.setCapability("accessKey", ACCESS_KEY);
		dc.setCapability("testName", "Quick Start Chrome Browser Demo");
		driver = new RemoteWebDriver(url, dc);

		
		
	}

	@Test
	public void browserTestGoogleSearch() {
		driver.get("https://www.google.co.in");
		
//		driver.findElement(By.linkText("Images")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		driver.findElement(By.linkText("English")).click();
		System.out.println(driver.getTitle());
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.click();
		searchBar.sendKeys("Bangalore", Keys.ENTER);

		System.out.println("Title: " + driver.getTitle());
	
		captureScreenShot(driver);
	 

	}

	@AfterMethod
	public void tearDown() {
		captureScreenShot(driver);
		driver.quit();
	}

	public static void captureScreenShot(WebDriver ldriver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile method
			Date  d =  new Date();
			String date =  d.toString();
			String fn =  date.replace(" ", "_").replace(":", "_").trim();
			

			FileUtils.copyFile(src, new File("./test-output/" + fn + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}
}