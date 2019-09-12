package SelAdv;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import day3.Utils;

public class PrintAllLinks {
	/**
	 * This will be headless no browser will open,
	 */
	WebDriver driver;

	@Test
	public void testLinks() throws IOException {
		System.setProperty("webdriver.chrome.driver", Utils.getValue("cpath"));
		ChromeOptions ops = new ChromeOptions();
		ops.setHeadless(true);
		driver = new ChromeDriver(ops);
		driver.manage().window().fullscreen();
		driver.get("https://www.google.com");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total no of links: " + links.size());

		for (WebElement ele : links) {
			// System.out.println(ele.getText());
			System.out.println(ele.getText() + " ----> " + ele.getAttribute("href"));

		}
		driver.quit();
	}

}
