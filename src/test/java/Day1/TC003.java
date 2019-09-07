package Day1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sep7.LogMyRep;

import org.testng.Assert;
import org.testng.Reporter;

//@Listeners(LogMyRep.class) 
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
		
		Assert.fail("Fail login....");
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
