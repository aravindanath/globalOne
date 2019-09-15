package SelAdv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class Calender  extends LaunchBrowser{
	
	
	@Test
	public void calenderdemo() throws InterruptedException {
		
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//*[@id='src']")).sendKeys("Ban");
		
		Thread.sleep(2000);
		
		List<WebElement> srcList = driver.findElements(By.xpath("//ul[@class='autoFill']/li"));
		
		for (WebElement webElement : srcList) {
			System.out.println("From:--> " +webElement.getText());
			 String fromCity =  webElement.getText();
			 if(fromCity.equals("Bellandur, Bangalore")) {
				 webElement.click();
				 break;
			 }
			
		}
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.id("dest")).sendKeys("Hyderabad (All Locations)");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='fl search-box date-box gtm-onwardCalendar']")).click();
		
		List<WebElement>dep = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table[1]//td"));
		
		for (WebElement webElement : dep) {
			
			String date =  webElement.getText();
			if(date.equals("26")) {
				webElement.click();
				break;
			}
			
			
		}
		Thread.sleep(5000);
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(2000);
	}

}
