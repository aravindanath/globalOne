package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class LocatorByTagname  extends LaunchBrowser{
	
	
	@Test
	public void linktext() throws InterruptedException  {
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.partialLinkText("Images")).click();
		
		driver.findElement(By.name("q")).sendKeys("Chandrayan 2",Keys.ENTER);
		
		Thread.sleep(5000);
		
		driver.navigate().back();
		
		driver.findElement(By.name("q")).sendKeys("Boston",Keys.ENTER);
		Thread.sleep(5000);
		
		driver.navigate().back();
		driver.navigate().forward();
		
		
		
	}
	
	

}
