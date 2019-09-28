package Sep15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class ByCssSelectorBYID extends LaunchBrowser{
	
	@Test
	public void byName() throws InterruptedException {
		
		driver.get("https://www.amazon.com/");
		/**
		 * '#' is for ID in css
		 */
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Noika 800 tough",Keys.ENTER);

	}

}
