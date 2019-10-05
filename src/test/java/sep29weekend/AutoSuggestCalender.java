package sep29weekend;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class AutoSuggestCalender extends LaunchBrowser {

	@Test
	public void calenderdemo() throws InterruptedException {

		driver.get("https://www.redbus.in/");

		driver.findElement(By.xpath("//*[@id='src']")).sendKeys("Ban");

		List<WebElement> srcList = driver.findElements(By.xpath("//ul[@class='autoFill']/li"));

		System.out.println("No of Pickup points ---> " + srcList.size());

		for (WebElement webElement : srcList) {
			System.out.println("From:--> " + webElement.getText());
			String src = webElement.getText();
			if (src.equals("Hebbal, Bangalore")) {
				webElement.click();
				break;
			}

			Thread.sleep(2000);

		}

		driver.findElement(By.id("dest")).sendKeys("Delhi (All Locations)");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='fl search-box date-box gtm-onwardCalendar']")).click();

		List<WebElement> onward = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table[1]//td"));

		for (WebElement webElement : onward) {
			String val = webElement.getText();

			if (val.equals("10")) {
				webElement.click();
				break;
			}
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='fl search-box date-box gtm-returnCalendar']")).click();

		List<WebElement> returnDt = driver.findElements(By.xpath("//div[@id='rb-calendar_return_cal']/table[1]//td"));
		for (WebElement webElement : returnDt) {
			String val = webElement.getText();

			if (val.equals("Oct 2019")) {
				driver.findElement(By.xpath("(//td[@class='next'])[2]")).click();
				break;
			}

		}

		Thread.sleep(2000);
		List<WebElement> returnDt1 = driver.findElements(By.xpath("//div[@id='rb-calendar_return_cal']/table[1]//td"));
		for (WebElement webElement2 : returnDt1) {
			String val1 = webElement2.getText();
			if (val1.equals("20")) {
				webElement2.click();
				break;
			}

		}

		Thread.sleep(5000);
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(2000);
	}
}
