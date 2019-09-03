package day3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class LocatorBYID extends LaunchBrowser{
	
	//<TAGNAME id='value',text='value',name='value',class='value',placeholder='value'> text </TAGNAME>
	
	@Test
	public void byID() throws InterruptedException, IOException {
		driver.get(Utils.getValue("url"));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Utils.getValue("search"),Keys.ENTER);
 
		
		Thread.sleep(2000);
		
		
	}


	@Test
	public void byName() throws InterruptedException, IOException {
		driver.get(Utils.getValue("url1"));
		driver.findElement(By.name("q")).sendKeys(Utils.getValue("search1"),Keys.ENTER);
 
		
		Thread.sleep(3000);
		
		
	}
}
