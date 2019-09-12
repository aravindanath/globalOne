package SelAdv;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class frames extends LaunchBrowser {
	
	@Test
	public void framestest() throws InterruptedException {
		
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		driver.switchTo().frame("packageListFrame");
		
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		
		driver.findElement(By.linkText("accept")).click();
		
		Thread.sleep(3000);
		
		String win = driver.getWindowHandle();
		System.out.println(win);
		
		
	}

}
