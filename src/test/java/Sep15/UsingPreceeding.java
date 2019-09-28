package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class UsingPreceeding extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {
 
		//driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		driver.get("https://www.nseindia.com/live_market/dynaContent/live_watch/equities_stock_watch.htm");
		
		String text = driver.findElement(By.xpath("//*[text()='11,593.60']//preceding::td[text()='NIFTY 50']")).getText();
		System.out.println("Market Name "+text);
		
		 
		
	 
		Thread.sleep(2000);

	}

}
