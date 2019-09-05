package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class DynamicElements extends LaunchBrowser {

	@Test
	public void dynamicElemenent() throws InterruptedException {

		driver.get("https://www.amazon.com");
		driver.findElement(By.xpath("//*[contains(text(),'Hello. Sign in') or contains(text(),'Hello, Sign in')  ]"))
				.click();
		Thread.sleep(2000);
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//*[contains(text(),'Hello. Sign in') or contains(text(),'Hello, Sign in')  ]"))
				.click();

		Thread.sleep(2000);
		
		driver.get("https://www.google.com");
//		driver.findElement(By.xpath("//input[starts-with(@class,'gL')]")).sendKeys("Selenium jobs in bangalore",Keys.ENTER);
		WebElement ele = driver.findElement(By.partialLinkText("Imag"));
		System.out.println("Is image is enabled?"+ ele.isEnabled());
		if(ele.isDisplayed()) {
			
			ele.click();
			driver.findElement(By.xpath("//input[starts-with(@class,'gL')]")).sendKeys("Selenium jobs in bangalore",Keys.ENTER);
		}
		driver.navigate().back();
		Thread.sleep(1000);
		WebElement country =driver.findElement(By.xpath("//*[text()='India']"));
		System.out.println("Country is displayed? "+country.isDisplayed());
		System.out.println("Is country is enabled?"+ country.isEnabled());
		
		Thread.sleep(2000);
	}

}
