package SelAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class Scroll extends LaunchBrowser {

	@Test
	public void scroll() throws InterruptedException {

		driver.get("https://www.amazon.in");
		Thread.sleep(1000);
		WebElement top = driver.findElement(By.xpath("//*[@id='navBackToTop']/div/span"));

		scrollTillElement(top, driver);
		Thread.sleep(2000);
		highlight(top);

		// arguments[0].style.border='3px solid red'
		Thread.sleep(2000);
 
		jsClick(driver, top);
		Thread.sleep(2000);

	}

	public static void scrollTillElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollDown(int size) {
		((JavascriptExecutor) driver).executeScript("scroll(0," + size + ")");
	}

	public void jsClick(WebDriver driver, WebElement ele) {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);

	}

	public void highlight(WebElement ele ) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid yellow'", ele);
	}

}
