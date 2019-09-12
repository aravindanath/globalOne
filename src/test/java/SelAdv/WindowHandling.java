package SelAdv;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class WindowHandling extends LaunchBrowser{

	
	@Test
	public void windowHandles() throws InterruptedException {
		
		driver.get("https://www.hdfcbank.com/");
		String ptitle = driver.getTitle();
		
		System.out.println(ptitle);
		
		System.out.println("========= Parent Window ===========");
 
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterate = windowId.iterator();
		System.out.println("First window ID " + iterate.next());
		
		driver.findElement(By.xpath("(//*[@id='loginsubmit'])[1]")).click();
		
		System.out.println("========Second Window opens========");
		windowId = driver.getWindowHandles();
		iterate = windowId.iterator();
		
		String firstwindow=iterate.next(); //window id of the main window
		String SecondWindow=iterate.next(); 
		
		System.out.println(SecondWindow);
		
		driver.switchTo().window(SecondWindow);
		System.out.println("======== Foucs is on Second Window ========");
//		windowId = driver.getWindowHandles();
//		iterate = windowId.iterator();
		
		String title1 =  driver.getTitle();
		System.out.println("Title: "+ title1);
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a")).click();
		Thread.sleep(2000);
		driver.close(); // latest window pop up
		Thread.sleep(3000);
		driver.switchTo().window(firstwindow);
		String title = driver.getTitle();
		System.out.println("Title: " + title);
	//	driver.quit();;
		
		
		
		
	}
	

}
