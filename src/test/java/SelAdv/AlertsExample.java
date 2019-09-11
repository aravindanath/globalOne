package SelAdv;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class AlertsExample extends LaunchBrowser{
	
	
	@Test
	public void handleAlerts() throws InterruptedException {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#login1")).sendKeys("arvind@rediff.com");
		
		Thread.sleep(2000);
		
		
	}

	@Test
	public void alertsHandling() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
		Alert alt = driver.switchTo().alert();
		alt.sendKeys("Hello all");
		alt.accept();
		Thread.sleep(2000);
		
		
		
		
	}
	
	
	
	
}
