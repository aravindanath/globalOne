package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchBrowser {

	WebDriver driver;
	
	@BeforeTest
	public void openBrowse() {
		// Windows path = d:\\user\\xyz\\chromedriver.exe
		String path = "/Users/aravindanathdm/Documents/Aravinda/chromedriver";
		System.setProperty("webdriver.chrome.driver", path);
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("disable-infobars");
		ops.addArguments("--disable-notifications");
		
		driver =  new ChromeDriver(ops);
		//For full screen
		driver.manage().window().fullscreen();
		//1. U hVE TO USE PROP FILE TO READ PATH
		//2. BROWQSER = CHROME / FF /EDGE
		
	}
	
	@Test
	public void openUrl() {
		driver.get("https://www.icicibank.com/");
		driver.findElement(By.xpath("//*[text()='LOGIN']")).click();
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	 
}
