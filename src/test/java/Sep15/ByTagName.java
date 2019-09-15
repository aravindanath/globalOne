package Sep15;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class ByTagName extends LaunchBrowser{
	
	@Test
	public void byName() throws InterruptedException {
		
		driver.get("https://www.google.com/");
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total no of links : "+links.size());
		
		
		for(WebElement ele : links) {
			System.out.println(ele.getText() + "--->"+ele.getAttribute("href"));
		}
	
	}

}
