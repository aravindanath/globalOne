package SelAdv;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Day1.LaunchBrowser;

public class CompleteApplication extends LaunchBrowser {

	@Test(priority = 1)
	public void partialLinkText() {
		driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
		String expected = driver.findElement(By.xpath("//a[@title='Automation Practice Form']")).getText();
		System.out.println("Expected :" + expected);
		verifyText(expected, "Partial Link Test");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void LinkText() {
		String expected = driver.findElement(By.xpath("//a[@title='Automation Practice Table']")).getText();
		System.out.println("Expected :" + expected);
		verifyText(expected, "Link Test");
		driver.findElement(By.xpath("//a[@title='Automation Practice Table']")).click();

		driver.navigate().to("https://www.toolsqa.com/automation-practice-table/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().forward();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().back();
	}

	@Test(priority = 3)
	public void textBox() {
		WebElement element = driver.findElement(By.name("firstname"));
		assertTitle(element.isDisplayed(), element.isDisplayed());
		element.sendKeys("Vinod");
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Sumanth");
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Yadhav");

	}

	 @Test(priority = 4)
	public void radioButton() throws InterruptedException {
		/**
		 * This is for scroll
		 */
		scrollDown(500);
		WebElement male = driver.findElement(By.id("sex-0"));
		male.click();
		WebElement female = driver.findElement(By.id("sex-1"));
		female.click();
		if (male.isSelected()) {
			female.click();
		} else if(female.isSelected()) {
			male.click();
		}
		Thread.sleep(2000);
	}

	  @Test(priority = 5)
	public void radioButtonsList() throws InterruptedException {

		List<WebElement> radio = driver.findElements(By.xpath("//div[@class='control-group'][6]/input"));
		System.out.println("Total No of Radio Buttons :" + radio.size());
		radio.get(4).click();
		radio.get(2).click();
		radio.get(5).click();
	}

	 @Test(priority = 6)
	public void datePicker() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("User is on datepicker");
		WebElement date = driver.findElement(By.id("datepicker"));
		System.out.println("Is data is displayed?" + date.isDisplayed());
		date.sendKeys("11/12/2018");
	}

	  @Test(priority = 7)
	public void checkBox() {
		System.out.println("User is on Checkbox");
		List<WebElement> cb = driver.findElements(By.xpath("//div[@class='control-group'][7]/input"));
		System.err.println("Total no of CB:" + cb.size());
		for (WebElement webElement : cb) {
			webElement.click();
		}
	}

	  @Test(priority = 8)
	public void fileUpload() throws InterruptedException {
		scrollDown(1200);
		wait(2000);
		String path = "/Users/aravindanathdm/eclipse-workspace/AutomationFrameworks/Output/fb.png";
		driver.findElement(By.xpath("//div[@class='control-group'][8]/input[@id='photo']")).sendKeys(path);
		wait(2000);
	}

	 @Test(priority = 9)
	public void selectAll() {

		WebElement sel = driver.findElement(By.id("selenium_commands"));
		Select select = new Select(sel);
		select.selectByVisibleText("Browser Commands");
		select.selectByIndex(1);
		select.selectByIndex(2);
		select.selectByIndex(3);
		select.selectByVisibleText("WebElement Commands");
	 

	}

	  @Test(priority = 10)
	public void deSelectAll() {
		wait(2000);
		WebElement ele = driver.findElement(By.id("selenium_commands"));
		deselectDd(ele, 2, "WebElement Commands");

	}

	 @Test(priority=11)
	public void fileDownLoad() {

		driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
		wait(2000);
	}

	public static void locator(WebDriver driver,By by) {
		driver.findElement(by);
	}

	public static void verifyText(String actual, String expected) {

		Assert.assertEquals(actual, expected, "Assert Fail due to mismatch in Actual vs Expected");
	}

	public static void assertTitle(boolean actual, boolean expected) {
		Assert.assertEquals(actual, expected, "First name text is present");

	}

	public static void softVerify(String actual, String expected) {
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(actual, expected, "Assert Fail due to mismatch in Actual vs Expected");
		sf.assertAll();
	}

	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {

		}
	}

	public static void deselectDd(WebElement ele, int index,String text) {
		Select s = new Select(ele);
		s.deselectByIndex(index);
	//	s.deselectByValue(value);
		s.deselectByVisibleText(text);
		s.deselectAll();

	}
	
	
	public void scrollDown(int size) {
		((JavascriptExecutor) driver).executeScript("scroll(0,"+size+")");
	}
}
