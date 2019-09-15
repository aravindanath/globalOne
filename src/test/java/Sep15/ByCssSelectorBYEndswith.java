package Sep15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class ByCssSelectorBYEndswith extends LaunchBrowser{
	
	@Test
	public void byName() throws InterruptedException {
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.cssSelector("input[type$='ail']")).sendKeys("Neeraj",Keys.ENTER);
		

	}

}
