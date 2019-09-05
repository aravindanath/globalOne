package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class SeleniumMethods extends LaunchBrowser {
	
	@Test
	public void disable() throws InterruptedException {
		driver.get("file:///Users/aravindanathdm/Desktop/bank.html");
		WebElement ele =driver.findElement(By.xpath("//button[@text='click' and contains(text(),'Click Me!')]"));
		System.out.println("Element is displayed?"+ele.isDisplayed());
		System.out.println("Element is enabled?"+ele.isEnabled());
		ele.click();
		
		driver.get("https://www.facebook.com/");
		WebElement fmale = driver.findElement(By.xpath("//input[@type='radio' and @value=1]"));
		
		System.out.println("Female radio btn is selected? "+fmale.isSelected());
		
		if(!fmale.isSelected()) {
			fmale.click();
			
			System.out.println("Female radio btn is selected? "+fmale.isSelected());
		}
		
		Thread.sleep(2000);
	}

}
