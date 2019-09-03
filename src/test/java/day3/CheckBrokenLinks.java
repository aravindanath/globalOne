package day3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class CheckBrokenLinks extends LaunchBrowser {

	@Test
	public void links() throws IOException {

		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links:" + links.size());

		for (WebElement ele : links) {

			System.out.println(ele.getText());

			String url = ele.getAttribute("href");

			System.out.println("Links: " + url);

			URL u = new URL(url);

			HttpURLConnection hp = (HttpURLConnection) u.openConnection();
			hp.connect();

			int res = hp.getResponseCode();

			// If the response code is > 400 then its treated as broken links
			if (res > 400) {
				System.err.println(url + "--->" + "is broken link / Client Error " + res);
			} else if (res >= 200 && res <= 300) {
				System.err.println(url + "--->" + "`k &  Success " + res);
			} else if (res >= 301 && res <= 400) {
				System.err.println(url + "--->" + "   link   Redirection " + res);
			} else if (res > 500) {
				System.err.println(url + "--->" + "   link  Server Error " + res);
			}

		}
	}

}
