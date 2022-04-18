package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class GetBrowserProperty {
	
	public String getBroserName()  {
		Properties prop = getPropertyObject(); 
		return prop.getProperty("browserName");
	}
	private Properties getPropertyObject()  {
		Properties prop = new Properties();
		try {
		String path = Paths.get("").toAbsolutePath().normalize().toString()+"\\testdata.properties";
		System.out.println("current path is "+path);
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		}
		catch(IOException e) {
			System.out.println("Caught an exception during reading the properties file");
		}
		return prop;
	}

	public String getSiteToVisit()  {
		Properties prop = getPropertyObject(); 
		return prop.getProperty("browserURL");
	}
}
