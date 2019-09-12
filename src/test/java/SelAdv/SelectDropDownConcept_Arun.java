package SelAdv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;


public class SelectDropDownConcept_Arun extends LaunchBrowser {

	// @Test(priority = 1)

	public void handleDropDown() throws InterruptedException {

		driver.get("https://www.wikipedia.org/");

		List<WebElement> lang = driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));
		System.out.println("The no. of languages available are :" + lang.size()); // size of list element

		// 1. General method (failed - need to try again)

		// driver.findElement(By.id("searchLanguage")).sendKeys("Deutsch");
		WebElement eleDrop = driver.findElement(By.id("searchLanguage"));
//		eleDrop.sendKeys("Deutsch");  // failing as its selecting 'Dansk' always. Matching first char.
//		Thread.sleep(3000);
//
//		eleDrop.sendKeys("English");
//		Thread.sleep(3000);

		// 2. Select Method

		Select sel = new Select(eleDrop);

		sel.selectByIndex(35);
		Thread.sleep(3000);

		sel.selectByValue("ja");

		Thread.sleep(3000);

		sel.selectByVisibleText("Nederlands");
		Thread.sleep(3000);

	}

	@Test(priority = 2)

	public void deselDropDown() throws InterruptedException {

		driver.get("https://www.toolsqa.com/automation-practice-form");

		WebElement ctry = driver.findElement(By.xpath("//label[text()='Continents']"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", ctry);

		WebElement country = driver.findElement(By.xpath("//select[@id='continentsmultiple']"));

		selByIndex(country, 1);
		// Thread.sleep(3000);
		
		selByVal(country, "AF");
		// Thread.sleep(3000);

		selByVisText(country, "South America");
		 Thread.sleep(3000);
		
		
		deselByIndex(country, 1);
		 Thread.sleep(3000);

		deselByVal(country, "AF");
		 Thread.sleep(3000);

		deselByVisText(country, "South America");
		 Thread.sleep(3000);

	}

	public void selByIndex(WebElement element, int value) {

		Select sel = new Select(element);
		sel.selectByIndex(value);
	}

	public void selByVal(WebElement element, String value) {

		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	public void selByVisText(WebElement element, String text) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}
	
	
	public void deselByIndex(WebElement element, int value) {

		Select sel = new Select(element);
		sel.deselectByIndex(value);
	}

	public void deselByVal(WebElement element, String value) {

		Select sel = new Select(element);
		sel.deselectByValue(value);

	}

	public void deselByVisText(WebElement element, String text) {

		Select sel = new Select(element);
		sel.deselectByVisibleText(text);

	}

}
