package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoAssertion extends LaunchBrowser {

	@Test(priority = 1)
	public void verifyTitle() {

		driver.get("https://www.flipkart.com");

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, title);
		int i =10;
		Assert.assertEquals(i, 100, "Number mismatch!");
 		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
 		Assert.assertTrue(search.isDisplayed(), "Search box is not displayed!");
		System.out.println(" ==== ending =====");

	}

	//@Test(priority = 1)
	public void test2() {
		SoftAssert sf = new SoftAssert();
		driver.get("https://www.google.com");

		String title = driver.getTitle();
		System.out.println(title);
		sf.assertEquals(title, "Amazon.com: Online for Electronics, Apparel, Computers, Books, DVDs & more<",
				"Title mismatch");

		System.out.println(" ==== ending =====");

		System.out.println("Test 2");
		sf.assertAll();
	}

}
