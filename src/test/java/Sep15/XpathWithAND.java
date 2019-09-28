package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class XpathWithAND extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {
 
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//input[@type='text' and @name='firstname']")).sendKeys("Vijay");
		Thread.sleep(2000);

	}

}
