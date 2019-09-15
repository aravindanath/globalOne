package Sep15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class ByClassName extends LaunchBrowser{
	
	@Test
	public void byName() throws InterruptedException {
		
		driver.get("https://www.icicibank.com/");
		
		driver.findElement(By.cssSelector(".pl-login-ornage-box")).click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
	
	}

}
