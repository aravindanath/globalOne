package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class AbsoluteXpath extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {

		driver.get("https://www.google.com");
		driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div/div/div/div[2]/input"))
				.sendKeys("Selnium jobs");
		
		Thread.sleep(2000);

	}

}
