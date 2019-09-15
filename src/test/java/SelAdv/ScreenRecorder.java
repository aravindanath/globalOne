package SelAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import sep14.LaunchBrowser;

/**
 * Link to download ATUTestRecorder
 * https://drive.google.com/file/d/0B6vnknygMB3IZVh3MWxnNUNfeEE/view
 * 
 * @throws ATUTestRecorderException
 */
public class ScreenRecorder extends LaunchBrowser {
	ATUTestRecorder recorder;

	@BeforeTest
	public void recStart() throws ATUTestRecorderException {
		recorder = new ATUTestRecorder("./test-output/demo", true);
		recorder.start();

	}

	@Test
	public void launchBrowser() {

		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("selenium jobs", Keys.ENTER);
	}

	@AfterTest
	public void stopRec() throws ATUTestRecorderException {

		recorder.stop();

	}

}
