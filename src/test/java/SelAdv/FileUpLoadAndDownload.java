package SelAdv;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class FileUpLoadAndDownload extends LaunchBrowser {

	@Test
	public void fileupload() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/upload");

		Thread.sleep(2000);

		String path = "/Users/aravindanathdm/eclipse-workspace/AutomationFrameworks/test-output/1556163558367.png";

		driver.findElement(By.id("file-upload")).sendKeys(path);
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(3000);
	}

	@Test(priority=2)
	public void fileDownload() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/download");

		Thread.sleep(2000);

		driver.findElement(By.linkText("test.txt")).click();
 
		Thread.sleep(3000);
	}
	
	
}
