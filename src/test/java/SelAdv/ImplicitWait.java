package SelAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class ImplicitWait extends LaunchBrowser {

	@Test
	public void waits() {

		driver.get("http://newtours.demoaut.com/mercurycruise.php");
	WebElement img =	driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/p[3]/a/img"));
	
		System.out.println(img.isDisplayed());
	}

}
