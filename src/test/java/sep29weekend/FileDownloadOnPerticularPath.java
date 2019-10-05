package sep29weekend;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FileDownloadOnPerticularPath {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/aravindanathdm/Documents/Aravinda/chromedriver");
		String downloadFilepath = "/Users/aravindanathdm/Documents/";

		driver = new ChromeDriver(fileDownload(downloadFilepath));
		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("File Download")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("test.txt")).click();
		Thread.sleep(2000);
		driver.quit();
	}

	public static ChromeOptions fileDownload(String path) {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", path);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions");
		return options;

	}

}
