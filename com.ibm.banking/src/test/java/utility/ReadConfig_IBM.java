package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig_IBM {

	Properties prop;
	

	public ReadConfig_IBM() throws Exception {

		FileInputStream fis = new FileInputStream(".\\testData\\config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getApp() {

		return prop.getProperty("nop_appURL");
	}

	public String getBrowserDetails() {

		return prop.getProperty("browser");
	}
	
	public String getUserName() {

		return prop.getProperty("userName");
	}

	public String getPassword() {

		return prop.getProperty("password");
	}

}
