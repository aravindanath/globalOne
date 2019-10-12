package sep29weekend;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class Frames extends LaunchBrowser {

	@Test
	public void frames() {

		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		// by index
		// driver.switchTo().frame(0);//packageListFrame
		driver.switchTo().frame("packageListFrame");

		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("DefaultSelenium")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		String cal = driver.findElement(By.xpath("//h2[@title='Class DefaultSelenium']")).getAttribute("class");

		System.out.println(cal);

	}
}
