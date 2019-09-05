package day3;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class LocatorAbsXpath extends LaunchBrowser{

	
	@Test
	public void loginFb() throws InterruptedException {
		
	driver.get("https://www.facebook.com");
	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[1]/input")).sendKeys("arvind@gmail.com");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("pass");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='submit' and @id='u_0_2']")).click();
	Thread.sleep(5000);
	
	
	}
}
