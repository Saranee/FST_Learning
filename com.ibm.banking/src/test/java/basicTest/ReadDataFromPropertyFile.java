package basicTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {
		
		
//		FileInputStream fis =  new FileInputStream("C:\\Users\\91995\\eclipse-workspace\\SeleniumAutomationBatch2\\testData\\config.properties");
		
		FileInputStream fis =  new FileInputStream("./testData/config.properties");
		
		
		 Properties prop = new Properties();
		 
		 
		 prop.load(fis);
		 
		 
		 String appURL = prop.getProperty("nop_appURL");
		
		 
		 
		System.out.println("Application URL " + appURL);
		System.out.println("Application username " + prop.getProperty("userName"));
		System.out.println("Application password " + prop.getProperty("password"));
		System.out.println("Application password " + prop.getProperty("sdfdfsdfsdf", "default Value"));

	}

}
