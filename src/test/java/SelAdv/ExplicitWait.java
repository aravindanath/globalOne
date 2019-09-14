package SelAdv;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class ExplicitWait extends LaunchBrowser {

	@Test
	public void explicitWaitEx() throws InterruptedException {
		
		driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		WebElement ele = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
		ele.click();
		Thread.sleep(1000);
		WebDriverWait wait =  new WebDriverWait(driver, 30);
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		alt.accept();
		 


	}

}
