package Sep15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class ByName extends LaunchBrowser{
	
	@Test
	public void byName() throws InterruptedException {
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("iphone 11 pro max",Keys.ENTER);
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);

	}

}
