package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class RelativeXpath extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {

		 //TAGNAME[@ATR|TRIBUE='VALUE']
		//html/body/div/div[4]/form/div[2]/div/div/div/div[2]/input
		//input[@name='q']
		//*[@name='q']
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']"))
				.sendKeys("Selnium jobs");
		Thread.sleep(2000);
		
		

	}

}
