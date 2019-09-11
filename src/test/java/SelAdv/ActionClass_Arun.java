package SelAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;


public class ActionClass_Arun extends LaunchBrowser {

	@Test

	public void mouseHoverTest() throws InterruptedException {

		driver.get("https://www.myntra.com/");

		WebElement tgt = driver.findElement(By.xpath("(//*[text()='Men'])[1]"));

		mousehover(driver, tgt);
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[text()='Sports Shoes'])[1]")).click();
		Thread.sleep(4000);

	}

	@Test

	public void dragDropTest() throws InterruptedException {

		driver.get("http://demo.guru99.com/test/drag_drop.html");

		WebElement src1 = driver.findElement(By.xpath("(//*[@class='button button-orange'])[2]"));
		// WebElement tgt1 = driver.findElement(By.xpath("//*[@id='amt8']"));
		WebElement tgt1 = driver.findElement(By.cssSelector("#amt8"));

		WebElement src2 = driver.findElement(By.xpath("(//*[@class='button button-orange'])[6]"));
		WebElement tgt2 = driver.findElement(By.cssSelector("#loan"));

		dragDrop(driver, src1, tgt1);
		Thread.sleep(3000);

		dragDrop(driver, src2, tgt2);
		Thread.sleep(3000);

		WebElement src3 = driver.findElement(By.xpath("(//*[@class='button button-orange'])[4]"));
		WebElement tgt3 = driver.findElement(By.cssSelector("#amt7"));
		dragDrop(driver, src3, tgt3);
		Thread.sleep(3000);

		WebElement src4 = driver.findElement(By.xpath("(//*[@class='button button-orange'])[5]"));
		WebElement tgt4 = driver.findElement(By.cssSelector("#bank"));
		dragDrop(driver, src4, tgt4);
		Thread.sleep(3000);

		WebElement btn = driver.findElement(By.xpath("(//*[@id='equal']/a)[1]"));
		doubleClick(driver, btn);

	}

	@Test

	public void doubleClick() {

	}

	public void mousehover(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();

	}

	public void dragDrop(WebDriver driver, WebElement src, WebElement tgt) {

		Actions act = new Actions(driver);
		act.dragAndDrop(src, tgt).build().perform();

	}
	
	public void doubleClick(WebDriver driver, WebElement btn) {

		Actions act = new Actions(driver);
		act.doubleClick(btn).build().perform();

	}

}
