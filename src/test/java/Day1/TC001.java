package Day1;

import org.testng.annotations.*;


import org.testng.Assert;
import org.testng.Reporter;

//This is a class level implementaion
//@Listeners(Day1.TestListener.class)
public class TC001 extends LaunchBrowser {

	@BeforeMethod
	public void beforeMethod() {
		System.err.println(" ====== Before method =====");
	}

	@AfterMethod
	public void afterMethod() {
		System.err.println(" ====== After method =====");
	}

	@Test
	public void url() {
		Reporter.log("User is on amazon page");
		driver.get("https://www.amazon.com");
		String title = driver.getTitle();
		Reporter.log("User is  on "+ driver.getCurrentUrl());
		Reporter.log(title);
		System.out.println("open url");
		
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

		Assert.fail("Fail...");
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
