package SelAdv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class RedBusDate {
	WebDriver driver;

	@Test
	public void dynamicDate() throws InterruptedException, IOException {

		ChromeOptions ops = new ChromeOptions();
		ops.setAcceptInsecureCerts(true);
		ops.addArguments("--disable-notifications");
		ops.addArguments("disable-infobars");
		ops.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "/Users/aravindanathdm/Documents/Aravinda/chromedriver");
		driver = new ChromeDriver(ops);
		driver.manage().window().fullscreen();

		driver.get("https://www.redbus.in/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='src']")).sendKeys("Ban");
		Thread.sleep(500);
		List<WebElement> from = driver.findElements(By.xpath("//*[@id='search']/div/div[1]/div/ul/li"));
		for (WebElement web : from) {
			String fromCity = web.getText();
			System.out.println("Cities : " + fromCity);
			if (fromCity.contains("Bangalore")) {
				web.click();
				break;
			}
		}

		driver.findElement(By.id("dest")).sendKeys("Mysore");
		Thread.sleep(500);
		List<WebElement> to = driver.findElements(By.xpath("//*[@id=\"search\"]/div/div[2]/div/ul/li"));
		for (WebElement web : to) {
			String toCity = web.getText();
			if (toCity.equals("Mysore")) {
				web.click();
				break;
			}
		}

		driver.findElement(By.xpath("//*[@class='fl search-box date-box gtm-onwardCalendar']")).click();

		Date d = todaysDate();
		System.err.println("Todays date:" + d);
		Thread.sleep(3000);

		List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table[1]//td"));
		String fd = getVal("./Files/object.properties", "fromdate");

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equals(fd)) {
				ele.click();
				break;
			}

			/**
			 * 45 ele in a list check for the month u r looking den click on >
			 * 
			 */

		}

		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[4]/span")).click();
		List<WebElement> renDate = driver
				.findElements(By.xpath("//div[@id='rb-calendar_return_cal']/table[1]/tbody/tr/td"));
		String tf = getVal("./Files/object.properties", "todate");
		for (WebElement webElement : renDate) {
			String date = webElement.getText();
			if (date.equals(tf)) {
				webElement.click();
				break;
			}
		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='search_btn']")).click();

	}

	// @Test
	public void scrollTOBottom() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,10000)");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("Colombia"));
		// Thread.sleep(2000);
		ele.click();
		// s.scrollTillElementFound(ele);

		// ((JavascriptExecutor) driver).executeScript("scroll(0,10000)");

	}

	public static Date todaysDate() {
		Date d = new Date();
		d.getDate();
		return d;
	}

	public static String getVal(String path, String key) throws IOException {

		FileInputStream fi = new FileInputStream(path);
		Properties porp = new Properties();
		porp.load(fi);
		String value = porp.getProperty(key);
		return value;

	}

}
