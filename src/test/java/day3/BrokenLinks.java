package day3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

 

public class BrokenLinks extends LaunchBrowser {

	@Test

	public void brokenLinks() throws InterruptedException, IOException {

		driver.get("https://www.google.com");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		// Number of links
		System.err.println("Total number of links: " + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement element = links.get(i);

			String url = element.getAttribute("href");

			URL link = new URL(url);
			// Create the http connection

			HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
			Thread.sleep(5000);
			// THis will establish the connection
			httpCon.connect();

			int res = httpCon.getResponseCode();
			// If the response code is > 400 then its treated as broken links
			if (res > 400) {
				System.err.println(url + "--->" + "is broken link / Client Error " + res);
			} else if (res >= 200 && res <= 300) {
				System.err.println(url + "--->" + "is vaild link &  Success " + res);
			} else if (res >= 301 && res <= 400) {
				System.err.println(url + "--->" + "   link   Redirection " + res);
			} else if (res > 500) {
				System.err.println(url + "--->" + "   link  Server Error " + res);
			}

		}

	}

}
