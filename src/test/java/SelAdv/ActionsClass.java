package SelAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class ActionsClass extends LaunchBrowser {

	@Test
	public void mouseHover() throws InterruptedException {

		driver.get("https://www.amazon.com");

		WebElement tgt = driver.findElement(By.xpath("//*[text()='Departments']"));
		
		Actions act =  new Actions(driver);
		act.moveToElement(tgt).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/a[12]/span")).click();
		//*[text()='Women's Fashion']
		

	}

}
