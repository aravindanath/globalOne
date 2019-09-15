package extentReportExample;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import sep14.LaunchBrowser;

/**
 * 
 * @author aravindanathdm <dependency> <groupId>com.aventstack</groupId>
 *         <artifactId>extentreports</artifactId> <version>4.0.9</version>
 *         </dependency>
 * 
 *         https://mvnrepository.com/artifact/com.aventstack/extentreports/4.0.9
 *
 */

public class ExtentReport4Demo  extends LaunchBrowser{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	 

	@BeforeTest
	public void setExtent() {
		//PAth to store the file
		htmlReporter = new ExtentHtmlReporter("./test-output/myExtentReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report for Regression Suite"); // Title of the report
		htmlReporter.config().setReportName("Functional Report for Amazon"); // name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Env", "Staging");
		extent.setSystemInfo("os", "macOS Mojave 10.14.6");
		extent.setSystemInfo("Tester Name", "ARAVINDA");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("BuildVersion", "v123.22");

	}

	@BeforeMethod
	public void setup() {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
				"/Users/aravindanathdm/Documents/Aravinda/chromedriver");

		driver = new ChromeDriver();
		System.out.println("Launch Browser");

		driver.get("https://www.amazon.com");
		

	}

	@Test
	public void TC0001() throws IOException {

		test = extent.createTest("TC0001");
		String title = driver.getTitle();
		System.out.println(title);
		test.info("User is on "+driver.getCurrentUrl());
		test.info("Title: " + title);
		test.info("=== user is on Amazon home page ====");

		test.log(Status.PASS, "THis case pass");

		Assert.assertEquals(title, title);

		try {
			int i = 10 / 0;
			System.out.println(i);
		} catch (Exception e) {
			test.error(e.getMessage());
			test.log(Status.FAIL, "\"Fail..\"");
			test.fail("Fail..");
			Assert.fail("Fail.....");
		}

	}

	@Test
	public void TC0002() throws IOException {

		test = extent.createTest("TC0002");
		String title = driver.getTitle();
		System.out.println(title);
		test.info("Title: " + title);
		test.info("=== user is on Amazon home page ====");

		test.log(Status.PASS, "THis case pass");

		Assert.assertEquals(title, title);

	}
	
	
	@Test
	public void TC0003()
	{
		test = extent.createTest("TC0003");
		throw new SkipException("Skip this case");
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Result status: " + result.getStatus());
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
			String screenshotPath = getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot go report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Result status: " + result.getStatus());
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Result status: " + result.getStatus());
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
