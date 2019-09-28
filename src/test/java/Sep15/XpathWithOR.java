package Sep15;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class XpathWithOR extends LaunchBrowser {

	@Test
	public void test() throws InterruptedException {
 
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.xpath("//input[@type='text' and  @name='firstname' or @id='u_0_m']")).sendKeys("Vijay");
		Thread.sleep(2000);

	}

}
