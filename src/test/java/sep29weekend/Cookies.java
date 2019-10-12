package sep29weekend;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import sep14.LaunchBrowser;

public class Cookies extends LaunchBrowser{
	
	@Test
	public void cookies() {
		
		driver.get("https://www.amazon.com");
		
		Set<Cookie>cook = driver.manage().getCookies();
		System.out.println("No of cookies: "+ cook.size());
		System.out.println(cook);
		driver.manage().deleteAllCookies();
		System.out.println(cook);
	}

}
