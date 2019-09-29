package sep29weekend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class SeleniumBuiltins extends LaunchBrowser {

	@Test
	public void methods() throws InterruptedException {

		driver.get("https://demo.midtrans.com/");
		String title = driver.getTitle();

		System.out.println("Title is : " + title);

		WebElement btn = driver.findElement(By.xpath("//a[@class='btn buy']"));

		if (btn.isEnabled()) {
			System.out.println("Btn is selected? " + btn.isSelected());
			System.out.println("Btn is Enabled? " + btn.isEnabled());
			System.out.println("Btn is displayed? " + btn.isDisplayed());
			btn.click();
		} else {
			System.out.println("Btn is not visible..");
		}

	}

}
