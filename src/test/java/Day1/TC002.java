package Day1;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002 extends LaunchBrowser {

	@Test
	public void url() {
		
		driver.get("https://www.yahoo.com");
		System.out.println("open url");
		Reporter.log("User is  on "+ driver.getCurrentUrl());
		String title = driver.getTitle();

		Reporter.log(title);
	}

	@Test
	public void search() {
		Reporter.log("user is on search page");
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
		throw new SkipException("Skipping,...");
		
	}

}
