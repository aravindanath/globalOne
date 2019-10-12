package sep29weekend;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class WindowHandling extends LaunchBrowser {
	
	@Test
	
	public void window() throws InterruptedException {
		
		driver.get("https://www.hdfcbank.com/");
		String url ="https://newsite.hdfcbank.com/personal?utm_source=current_website&utm_medium=hp_redirection&utm_campaign=newwebsitecampaign";
		if(driver.getCurrentUrl().equals(url)) {
			driver.get("https://www.hdfcbank.com/");
		}
		try {
			driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		System.out.println("Page Title -->"+ driver.getTitle());
		//String win1 = driver.getWindowHandle();
	//	System.out.println("First window"+ win1);
		System.out.println("========= Parent Window ===========");
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterate = windowId.iterator();
		System.out.println("First window ID " + iterate.next());
		
		driver.findElement(By.cssSelector("#loginsubmit")).click();
		windowId = driver.getWindowHandles();
		iterate = windowId.iterator();
		
		String firstwindow=iterate.next(); //window id of the main window
		String SecondWindow=iterate.next(); 
		
		System.out.println("First window ID " + firstwindow );
		System.out.println("Second window ID " + SecondWindow);
		driver.switchTo().window(SecondWindow);
		
		System.out.println("Page Title -->"+ driver.getTitle()); 	
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(firstwindow);
		
		System.out.println("Page Title -->"+ driver.getTitle()); 
		driver.findElement(By.cssSelector("#loginsubmit")).click();
		
	}

}
