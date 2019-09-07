package sep7;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class TC001 extends LaunchBrowser {
	
	
	
	@Test 
	public void loginAmazon() {
		Reporter.log("user is on amazon");
		driver.get("https://www.amazon.com");
		String title = driver.getTitle();
		Reporter.log(title);
		Reporter.log(driver.getCurrentUrl());
		
		System.out.println(title);
		System.out.println("Login ");
		
		
	}
//	@Test(priority=1)
//	public void loginAmazonin() {
//		driver.get("https://www.amazon.in");
//		String title = driver.getTitle();
//		
//		System.out.println(title);
//		System.out.println("Login ");
//		
//		
//	}
//	
	
	

}
