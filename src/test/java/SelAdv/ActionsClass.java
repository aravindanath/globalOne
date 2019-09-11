package SelAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class ActionsClass extends LaunchBrowser {
//http://the-internet.herokuapp.com/
	@Test
	public void mouseHoverTest() throws InterruptedException {

		driver.get("https://www.amazon.com");

		WebElement tgt = driver.findElement(By.xpath("//*[text()='Departments']"));
		mouseHover(driver, tgt);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/a[12]/span")).click();

	}

	@Test
	public void dragDropTest() throws InterruptedException {

		driver.get("http://demo.guru99.com/test/drag_drop.html");
		WebElement src1 = driver.findElement(By.xpath("(//*[@id='fourth']/a)[1]"));
		WebElement tgt1 = driver.findElement(By.cssSelector("#amt8"));

		WebElement src2 = driver.findElement(By.xpath("//*[@id='credit1']/a"));
		WebElement tgt2 = driver.findElement(By.cssSelector("#loan"));
		
		dragDrop(driver, src1, tgt1);
		dragDrop(driver, src2, tgt2);
		Thread.sleep(2000);
		
	//	WebElement ele =  driver.findElement(By.xpath("(//*[@id=\"equal\"]/a)[1]"));
	//	doubleClick(driver, ele);
		rightClick(driver, src1);
		Thread.sleep(2000);
	}

	
	
	
	/**
	 * @author aravindanathdm
	 * @param driver
	 * @param element
	 * 
	 *            THis method is used for mouse hover
	 */

	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public static void dragDrop(WebDriver driver, WebElement src, WebElement tgt) {
		
		Actions act =  new Actions(driver);
		act.dragAndDrop(src, tgt).build().perform();

	}

	
	public static void doubleClick(WebDriver driver, WebElement ele) {
		
		Actions act =  new Actions(driver);
		act.doubleClick(ele).build().perform();

	}
	
	
	
	public static void rightClick(WebDriver driver, WebElement tgt) {
		
		Actions act =  new Actions(driver);
		act.contextClick(tgt).build().perform();

	}
	
	public static void clickHold(WebDriver driver, WebElement tgt) {
		
		Actions act =  new Actions(driver);
		act.clickAndHold(tgt).build().perform();
		act.release().build().perform();

	}
	

}
