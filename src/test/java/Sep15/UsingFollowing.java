package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class UsingFollowing extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {
 
		//driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		driver.get("https://www.nseindia.com/live_market/dynaContent/live_watch/equities_stock_watch.htm");
		
		String text = driver.findElement(By.xpath("//*[text()='NIFTY 50']//following::td[3]")).getText();
		System.out.println("Open price "+text);
		
		String company = "ITC";
		String xpath ="//*[text()='COMP']//following::td[3]".replace("COMP", company);
		String text2 = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(company+" Open price "+text2);
		
	 
		Thread.sleep(2000);

	}

}
