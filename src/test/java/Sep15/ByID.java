package Sep15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class ByID extends LaunchBrowser{
	
	@Test
	public void id() throws InterruptedException {
		
		driver.get("https://www.amazon.com");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11 pro max",Keys.ENTER);
		
		Thread.sleep(2000);
		
	}

}
