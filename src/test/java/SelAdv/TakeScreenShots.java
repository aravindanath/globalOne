package SelAdv;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import sep14.LaunchBrowser;

/**
 * 
 * @author aravindanathdm
 *
 *         <dependency> <groupId>ru.yandex.qatools.ashot</groupId>
 *         <artifactId>ashot</artifactId> <version>1.5.4</version> </dependency>
 * 
 * 
 */

public class TakeScreenShots extends LaunchBrowser {

	@Test(description = "Invalid Login Scenario with wrong username and password.")
	public void homePage() throws Exception {

		driver.get("https://www.amazon.com");
		takeFullSceenshot(driver);
		driver.get("https://www.flipkart.com");
		takeNormalScreenShot(driver);
		
		
 
		
	}

	/**
	 * @author aravindanathdm This method will take fullscreen screenshot.
	 * @param webdriver
	 * @throws Exception
	 */

	public static void takeFullSceenshot(WebDriver driver) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		Date d = new Date();
		String name = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = "./test-output/demo" + name;
		ImageIO.write(screenshot.getImage(), "png", new File(filePath));

	}
	

	public static void takeNormalScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String name = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = "./test-output/demo" + name;
		
		File target = new File(filePath);
		FileUtils.copyFile(src, target);
	}
}
