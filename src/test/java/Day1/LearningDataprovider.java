package Day1;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearningDataprovider {

	@Test(dataProvider="data")
	public void openurl(String userName,String password ) throws InterruptedException {
		 System.out.println(userName);
		 System.out.println(password);
	}

	@DataProvider
	public Object[][] data() {  //row , col
		Object[][] data = new Object[3][2];
		data[0][0] = "ankush@myntra.com";
		data[0][1] = "myntr234a#123";
		data[1][0] = "chitra@myntra.com";
		data[1][1] = "myntra#12323";
		data[2][0] = "Shreeleka@myntra.com";
		data[2][1] = "sree#12323";

		return data;

	}

}
