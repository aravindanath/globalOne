package sep29weekend;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class SelniumBuiltins extends LaunchBrowser {
	
	
	
	@Test
	public void builtIns() throws InterruptedException {
		
		
		driver.get("https://www.google.com");
		driver.manage().window().fullscreen();
		driver.findElement(By.partialLinkText("Imag")).click();
		driver.findElement(By.name("q")).sendKeys("Boston",Keys.ENTER);
		driver.navigate().back();
		driver.findElement(By.name("q")).sendKeys("Marathalli");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Bangalore",Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		
	
		
		
		
	}

}
