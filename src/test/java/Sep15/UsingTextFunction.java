package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class UsingTextFunction extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {
 
		driver.get("https://en-gb.facebook.com/");
		String text = driver.findElement(By.xpath("//span[text()='Create an account']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[contains(@type,'su')]")).click();
		Thread.sleep(2000);

	}

}
