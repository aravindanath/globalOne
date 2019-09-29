package sep29weekend;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.LaunchBrowser;

public class AlertsAndPopups extends LaunchBrowser {

	@Test
	public void methods() throws InterruptedException {

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#login1")).sendKeys("aravind@rediff.com");

	}

	@Test
	public void popup() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		gettext();
		waitforsometime(2000);
		accept();

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		gettext();
		waitforsometime(2000);
		dismiss();

		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		gettext();
		sendVal("Hello guys good morning..");
		waitforsometime(2000);
		accept();
		
		WebElement txt= driver.findElement(By.xpath("//p[@id='result']"));
		System.out.println(txt.getText());
		waitforsometime(2000);
	}

	public void accept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void dismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public void gettext() {
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		;

	}

	public void sendVal(String val) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(val);

	}

	public void waitforsometime(int mill) throws InterruptedException {
		Thread.sleep(mill);
	}
	
}
