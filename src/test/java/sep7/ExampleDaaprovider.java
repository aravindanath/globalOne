package sep7;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class ExampleDaaprovider extends LaunchBrowser {
	
	
	@Test(dataProvider="testdata")
	public void login(String email, String pass) throws InterruptedException {
		
		driver.get("https://www.myntra.com/login");
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).click();
		
		Thread.sleep(2000);
		
	}
	
	
	
	
	

	@DataProvider
	public Object[][] testdata() { // row , col
		Object[][] data = new Object[3][2];
		data[0][0] = "nidhi@myntra.com";
		data[0][1] = "myntr234a#123";
		data[1][0] = "bose@myntra.com";
		data[1][1] = "myntra#12323";
		data[2][0] = "smita@myntra.com";
		data[2][1] = "sree#12323";

		return data;
	}

}
