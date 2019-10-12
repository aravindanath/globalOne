package sep29weekend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class MouseActions extends LaunchBrowser {

//	@Test

	public void mouse() throws InterruptedException {

		driver.get("https://www.hdfcbank.com/");
		try {
			if (driver.getCurrentUrl().equals(
					"https://newsite.hdfcbank.com/personal?utm_source=current_website&utm_medium=hp_redirection&utm_campaign=newwebsitecampaign")) {
				driver.get("https://www.hdfcbank.com/");
				driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		WebElement prod = driver.findElement(By.xpath("//*[text()='Products']"));
		mouseHover(prod);
		Thread.sleep(1000);
		WebElement card = driver.findElement(By.linkText("Cards"));
		mouseHover(card);
		Thread.sleep(1000);
		WebElement cc = driver.findElement(By.linkText("Debit Cards"));
		mouseClick(cc);
		Thread.sleep(1000);

	}
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement src1 = driver.findElement(By.xpath("(//*[@id='fourth']/a)[1]"));
		WebElement tgt1 = driver.findElement(By.xpath("//*[@id='amt7']/li"));
		WebElement src2 = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		WebElement tgt2 = driver.findElement(By.xpath("//*[@id=\"bank\"]"));
		
		dragNDropElement(src1, tgt1);
		Thread.sleep(1000);
		dragNDropElement(src2, tgt2);
		Thread.sleep(2000);
	
		

	}
	
	
//	@Test
	public void draganddrop() throws InterruptedException {
		
		 driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		 
		 Thread.sleep(2000);
		 WebElement sr1 = driver.findElement(By.id("column-a"));
		 WebElement dec1 = driver.findElement(By.id("column-b"));
		 Actions act =  new Actions(driver);
		 act.dragAndDrop(dec1, sr1).build().perform();
		 
	}
	
	
	
	public void dragNDropElement(WebElement src, WebElement tgt) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, tgt).build().perform();
	}
	
	
	public void mouseHover(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		
	}
	public void mouseClick(WebElement ele) {
		Actions act = new Actions(driver);
		act.click(ele).build().perform();
		
	}

	
	
}
