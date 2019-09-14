package sep14;

import org.testng.annotations.Test;

public class ByID extends LaunchBrowser{
	
	@Test
	public void byID() {
		driver.get("https://www.icicibank.com/");
		
	}

}
