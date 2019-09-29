package sep29weekend;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class SelectDropDown extends LaunchBrowser {

	@Test
	public void selectdropdown() throws InterruptedException {

		driver.get("https://www.wikipedia.org/");
		driver.manage().window().fullscreen();
		// driver.findElement(By.xpath("//select[@id='searchLanguage']")).sendKeys("Српски
		// / Srpski");
		WebElement ele = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		Select sel = new Select(ele);
		sel.selectByIndex(30);
		Thread.sleep(2000);
		sel.selectByVisibleText("한국어");
		Thread.sleep(2000);
		sel.selectByValue("azb");
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void disselect() throws InterruptedException {

		driver.get("https://www.toolsqa.com/automation-practice-form/");
		WebElement cont = driver.findElement(By.xpath("//label[text()='Continents']"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", cont);

		WebElement country = driver.findElement(By.xpath("//select[@id='continentsmultiple']"));
		selectBYIndex(country, 4);
		Thread.sleep(2000);
		selectBYValue(country, "EU");
		Thread.sleep(2000);
		selectByVisibleText(country, "Antarctica");
		Thread.sleep(2000);
		diSelectBYValue(country, "EU");
		Thread.sleep(2000);
		diSelectBYIndex(country, 4);
		Thread.sleep(2000);
		diSelectByVisibleText(country, "Antarctica");
		Thread.sleep(2000);
		selectBYIndex(country, 4);
		Thread.sleep(2000);
		selectBYValue(country, "EU");
		Thread.sleep(2000);
		selectByVisibleText(country, "Antarctica");
		Thread.sleep(2000);
		diSelectByAll(country);
		Thread.sleep(2000);

	}

	public static void diSelectByAll(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}

	public static void selectBYValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public static void selectBYIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public static void diSelectBYValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}

	public static void diSelectBYIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	public static void diSelectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}

}
