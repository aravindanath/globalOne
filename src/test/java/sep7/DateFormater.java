package sep7;

import java.util.Date;

public class DateFormater {
	
	public static void main(String[] args) {
		
		
		
		Date  d =  new Date();
		String date =  d.toString();
		System.out.println(d);
		//Sat Sep 07 08:57:14 IST 2019
		
		String fn =  date.replace(" ", "_").replace(":", "_").trim();
		System.out.println(fn);
		
		
	}

}
