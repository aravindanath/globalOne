package SelAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class SeleniumBuiltins extends LaunchBrowser{
	
	
	@Test
	public void methods() throws InterruptedException {
		
		driver.get("https://demo.midtrans.com/");
		String title = driver.getTitle();
		System.out.println(title);;
		
		String pg = driver.getPageSource();
		
		System.out.println(pg);
		
		System.out.println(driver.getCurrentUrl());
		
		WebElement ele = driver.findElement(By.xpath("//a[@class='btn buy']"));	
		
		if(ele.isDisplayed()) {
			ele.click();
		}
		
		Thread.sleep(2000);
		
		
		 

		
		
	}
	
	

}
