package SelAdv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class SelectDropDown extends LaunchBrowser {

	@Test(priority = 1)
	public void dropdown() throws InterruptedException {
		driver.get("https://www.wikipedia.org");
		WebElement langdrop = driver.findElement(By.id("searchLanguage"));
		langdrop.sendKeys("Deutsch");
		Thread.sleep(5000);
		selectBYIndex(langdrop, 20);
		Thread.sleep(3000);
		selectBYValue(langdrop, "min");
		Thread.sleep(3000);
		selectByVisibleText(langdrop, "日本語");
		
//		Select sel = new Select(langdrop);
//		Thread.sleep(3000);
//		sel.selectByIndex(40);
//		Thread.sleep(3000);
//		sel.selectByValue("min");
//		Thread.sleep(3000);
//		sel.selectByVisibleText("日本語");
//		Thread.sleep(3000);
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

	public static void diSelectByVisibleText(WebElement element,String text) {
		Select sel =  new Select(element);
		sel.deselectByVisibleText(text);
	
	

}}
