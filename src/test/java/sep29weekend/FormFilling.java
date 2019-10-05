package sep29weekend;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class FormFilling extends LaunchBrowser {
	
	@Test
	public void F() throws InterruptedException {
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		
		String header = driver.findElement(By.xpath("//h1[text()='Automation Practice Form']")).getText();
		Assert.assertEquals(header, "Automation Practice Form","Title mis match!");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//strong[text()='Link Test']")).click();
//		
//		Thread.sleep(2000);
//		
//		driver.navigate().back();
//		Thread.sleep(2000);
//		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Neeraj");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("sinha");
		
		Thread.sleep(2000);
		
//		driver.findElement(By.cssSelector("#buttonwithclass")).click();;
		//input[@id='sex-1']
		Thread.sleep(1000);
		WebElement male = driver.findElement(By.xpath("//input[@id='sex-0']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='sex-1']"));
		if(!female.isSelected()) {
			female.click();
		}
		if(female.isSelected()) {
			male.click();
		}
														//Horizonatl, vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(2000);
		List<WebElement>radio = driver.findElements(By.xpath("//input[@name='exp']"));
		int count =  radio.size();
		System.out.println("No of radio buttons: "+ count);
		
		for (WebElement webElement : radio) {
			webElement.click();
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("datepicker")).sendKeys("20/01/2019");
		
		List<WebElement>cb =driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for (WebElement webElement : cb) {
			webElement.click();
		}
		String path = "/Users/aravindanathdm/eclipse-workspace/AutomationFrameworks/test-output/1556163558367.png";
		
		driver.findElement(By.id("photo")).sendKeys(path);
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Test File to Download")).click();
		Thread.sleep(2000);
		
	}

}
