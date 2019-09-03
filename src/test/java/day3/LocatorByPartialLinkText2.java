package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class LocatorByPartialLinkText2  extends LaunchBrowser{
	
	
	@Test
	public void linktext() throws InterruptedException  {
		
		driver.get("https://www.google.com");
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total no of Links: "+links.size());
		
		for (WebElement ele : links) {
			
			System.out.println(ele.getText());
			
		}
		
		 
		

	}
	
	

}
