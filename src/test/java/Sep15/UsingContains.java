package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class UsingContains extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {
 
		driver.get("https://en-gb.facebook.com/");
		String text = driver.findElement(By.xpath("//*[contains(text(),' quick and easy')]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[contains(@type,'su')]")).click();
		Thread.sleep(2000);

	}

}
