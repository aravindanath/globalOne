package sep7;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class TC002 extends LaunchBrowser {
	
	
	
	@Test 
	public void loginAmazon() {
		driver.get("https://www.flipkart.com");
		String title = driver.getTitle();
		
		System.out.println(title);
		System.out.println("Login ");
		
		
	}
	
	
	

}
