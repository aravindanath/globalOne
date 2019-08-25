package Day1;

import org.testng.annotations.Test;
import org.testng.Reporter;

 
public class TC003  extends LaunchBrowser{
	
 

	
	@Test
	public void url() {
		driver.get("https://www.google.com");
		System.out.println("open url");
		Reporter.log("User is  on "+ driver.getCurrentUrl());
		String title = driver.getTitle();

		Reporter.log(title);
	}
	
	@Test
	public void search() {
		System.out.println("search");
	}
	
	
	@Test
	public void login() {
		System.out.println("login");
	}
	
	
	@Test
	public void addCart() {
		System.out.println("add cart");
	}
	 
	
	
	@Test
	public void addAdd() {
		System.out.println("add Add");
	}
	
	
	@Test
	public void cod() {
		System.out.println("cod");
	}
 
	
 
	 
}
