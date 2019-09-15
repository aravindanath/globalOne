package Sep15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class ByCssSelectorBYClassName extends LaunchBrowser{
	
	@Test
	public void byName() throws InterruptedException {
		
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Noika 800 tough",Keys.ENTER);
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
	
	}

}
