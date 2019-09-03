package day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	
	
	public static String getValue(String key) throws IOException {
		FileInputStream fis =  new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String val = prop.getProperty(key);
		return val;
	}

}
